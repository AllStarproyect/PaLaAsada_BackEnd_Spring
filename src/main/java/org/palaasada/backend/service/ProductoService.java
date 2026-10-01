package org.palaasada.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.palaasada.backend.model.*;
import org.palaasada.backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Producto> findAll() {
        List<Producto> productos = productoRepository.findAll();
        cargarCategoriasYTags(productos);
        return productos;
    }

    public Optional<Producto> findById(String id) {
        Optional<Producto> producto = productoRepository.findById(id);
        producto.ifPresent(p -> cargarCategoriasYTags(List.of(p)));
        return producto;
    }

    @Transactional
    public Producto save(Producto producto) {
        Producto guardado = productoRepository.save(producto);
        // null = no se enviaron, se dejan como estan; lista vacia = quitar todos
        if (producto.getCategorias() != null) guardarCategorias(guardado, producto.getCategorias());
        if (producto.getTags() != null) guardarTags(guardado, producto.getTags());
        em.flush();
        cargarCategoriasYTags(List.of(guardado));
        return guardado;
    }

    public Producto update(String id, Producto producto) {
        producto.setId(id);
        return save(producto);
    }

    // Llena categorias y tags de todos los productos con 2 consultas en total
    // (no una por producto)
    private void cargarCategoriasYTags(List<Producto> productos) {
        if (productos.isEmpty()) return;
        List<String> ids = productos.stream().map(Producto::getId).toList();

        Map<String, List<String>> categorias = agrupar(em.createQuery(
                        "SELECT pc.id.productoId, c.nombre FROM ProductoCategoria pc, Categoria c "
                                + "WHERE c.categoriaId = pc.id.categoriaId AND pc.id.productoId IN :ids",
                        Object[].class)
                .setParameter("ids", ids).getResultList());

        // Solo tags vigentes (sin fecha de expiracion o que aun no expiran)
        Map<String, List<String>> tags = agrupar(em.createQuery(
                        "SELECT pt.id.productoId, pt.tag.nombre FROM ProductoTag pt "
                                + "WHERE pt.id.productoId IN :ids "
                                + "AND (pt.fechaExpiracion IS NULL OR pt.fechaExpiracion > :ahora)",
                        Object[].class)
                .setParameter("ids", ids).setParameter("ahora", LocalDateTime.now())
                .getResultList());

        for (Producto p : productos) {
            p.setCategorias(categorias.getOrDefault(p.getId(), new ArrayList<>()));
            p.setTags(tags.getOrDefault(p.getId(), new ArrayList<>()));
        }
    }

    private Map<String, List<String>> agrupar(List<Object[]> filas) {
        Map<String, List<String>> mapa = new HashMap<>();
        for (Object[] fila : filas) {
            mapa.computeIfAbsent((String) fila[0], k -> new ArrayList<>()).add((String) fila[1]);
        }
        return mapa;
    }

    // Reemplaza las categorias del producto. Los nombres que no existen se ignoran.
    private void guardarCategorias(Producto producto, List<String> nombres) {
        borrarPorProducto("ProductoCategoria", "id.productoId", producto.getId());
        if (nombres.isEmpty()) return;
        List<Categoria> categorias = em.createQuery(
                        "SELECT c FROM Categoria c WHERE c.nombre IN :nombres", Categoria.class)
                .setParameter("nombres", nombres).getResultList();
        for (Categoria c : categorias) {
            em.persist(new ProductoCategoria(
                    new ProductoCategoriaId(producto.getId(), c.getCategoriaId())));
        }
    }

    // Reemplaza los tags del producto. Si un tag no existe se crea (asignacion manual).
    private void guardarTags(Producto producto, List<String> nombres) {
        borrarPorProducto("ProductoTag", "id.productoId", producto.getId());
        Set<String> vistos = new HashSet<>();
        for (String nombre : nombres) {
            if (nombre == null || nombre.isBlank()) continue;
            String normalizado = nombre.trim().toUpperCase();
            if (!vistos.add(normalizado)) continue;

            Tag tag = em.createQuery("SELECT t FROM Tag t WHERE UPPER(t.nombre) = :n", Tag.class)
                    .setParameter("n", normalizado).getResultStream().findFirst()
                    .orElseGet(() -> {
                        Tag nuevo = new Tag(null, normalizado, TipoAsignacion.manual, false);
                        em.persist(nuevo);
                        return nuevo;
                    });

            em.persist(new ProductoTag(new ProductoTagId(producto.getId(), tag.getTagId()),
                    producto, tag, LocalDateTime.now(), null));
        }
    }

    // Elimina el producto junto con sus filas dependientes (categorias, tags,
    // carritos, historiales) y su precio/inventario/imagen/info si nadie mas los usa.
    // Devuelve false si no existe. Lanza IllegalStateException si tiene pedidos,
    // para no perder el historial de ventas.
    @Transactional
    public boolean delete(String id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto == null) return false;

        Long pedidos = em.createQuery(
                        "SELECT COUNT(d) FROM DetallePedido d WHERE d.producto.id = :id", Long.class)
                .setParameter("id", id).getSingleResult();
        if (pedidos > 0) {
            throw new IllegalStateException(
                    "El producto aparece en " + pedidos + " pedido(s) y no se puede eliminar.");
        }

        borrarPorProducto("CarritoProducto", "producto.id", id);
        borrarPorProducto("ProductoTag", "id.productoId", id);
        borrarPorProducto("ProductoCategoria", "id.productoId", id);
        borrarPorProducto("HistorialInventario", "producto.id", id);
        borrarPorProducto("HistorialPrecio", "producto.id", id);

        productoRepository.delete(producto);
        em.flush();

        borrarSiHuerfano("precio", producto.getPrecio());
        borrarSiHuerfano("inventario", producto.getInventario());
        borrarSiHuerfano("imagen", producto.getImagen());
        borrarSiHuerfano("informacionAdicional", producto.getInformacionAdicional());
        return true;
    }

    private void borrarPorProducto(String entidad, String campo, String id) {
        em.createQuery("DELETE FROM " + entidad + " e WHERE e." + campo + " = :id")
                .setParameter("id", id).executeUpdate();
    }

    // Borra la fila (precio, inventario...) solo si ningun otro producto la referencia
    private void borrarSiHuerfano(String relacion, Object fila) {
        if (fila == null) return;
        Long usos = em.createQuery(
                        "SELECT COUNT(p) FROM Producto p WHERE p." + relacion + " = :fila", Long.class)
                .setParameter("fila", fila).getSingleResult();
        if (usos == 0) em.remove(em.contains(fila) ? fila : em.merge(fila));
    }
}
