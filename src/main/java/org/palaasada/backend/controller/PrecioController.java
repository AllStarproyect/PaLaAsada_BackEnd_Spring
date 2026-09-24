package org.palaasada.backend.controller;

import org.palaasada.backend.model.Precio;
import org.palaasada.backend.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/precios")
public class PrecioController {

    @Autowired
    private PrecioService precioService;

    @GetMapping
    public ResponseEntity<List<Precio>> findAll() {
        return ResponseEntity.ok(precioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Precio> findById(@PathVariable String id) {
        return precioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Precio> save(@RequestBody Precio precio) {
        return ResponseEntity.ok(precioService.save(precio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Precio> update(
            @PathVariable String id,
            @RequestBody Precio precio) {

        return ResponseEntity.ok(precioService.update(id, precio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        precioService.delete(id);

        return ResponseEntity.noContent().build();
    }
}