package org.palaasada.backend.controller;

import org.palaasada.backend.model.Carrito;
import org.palaasada.backend.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<List<Carrito>> findAll() {
        return ResponseEntity.ok(carritoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> findById(@PathVariable Integer id) {
        return carritoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrito> save(
            @RequestBody Carrito carrito) {

        return ResponseEntity.ok(carritoService.save(carrito));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> update(
            @PathVariable Integer id,
            @RequestBody Carrito carrito) {

        return ResponseEntity.ok(
                carritoService.update(id, carrito)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        carritoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}