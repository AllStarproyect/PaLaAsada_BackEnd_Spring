package org.palaasada.backend.controller;

import org.palaasada.backend.model.Direccion;
import org.palaasada.backend.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public ResponseEntity<List<Direccion>> findAll() {
        return ResponseEntity.ok(direccionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> findById(@PathVariable Integer id) {
        return direccionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Direccion> save(
            @RequestBody Direccion direccion) {

        return ResponseEntity.ok(
                direccionService.save(direccion)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> update(
            @PathVariable Integer id,
            @RequestBody Direccion direccion) {

        return ResponseEntity.ok(
                direccionService.update(id, direccion)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        direccionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}