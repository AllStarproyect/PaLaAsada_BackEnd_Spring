package org.palaasada.backend.controller;

import org.palaasada.backend.model.Producto;
import org.palaasada.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable String id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear producto
    @PostMapping
    public ResponseEntity<Producto> save(
            @RequestBody Producto producto) {

        return ResponseEntity.ok(productoService.save(producto));
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(
            @PathVariable String id,
            @RequestBody Producto producto) {

        return ResponseEntity.ok(
                productoService.update(id, producto)
        );
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {

        try {
            if (!productoService.delete(id)) {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalStateException e) {
            // Tiene pedidos: 409 con el motivo para mostrarlo en /admin
            return ResponseEntity.status(409).body(e.getMessage());
        }

        return ResponseEntity.noContent().build();
    }
}