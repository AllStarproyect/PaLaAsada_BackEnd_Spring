package org.palaasada.backend.repository;

import org.palaasada.backend.model.Producto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>{

    // Trae el producto con precio, inventario, imagen, info y categoria en UNA
    // sola consulta (evita ~5 consultas extra por producto contra la BD remota)
    @Override
    @EntityGraph(attributePaths = {
            "precio", "inventario", "imagen",
            "informacionAdicional", "categoriaPrincipal"
    })
    List<Producto> findAll();

    //Creacion de métodos abstractos para realizar consultas
    Producto findByNombre(String nombre);
}






