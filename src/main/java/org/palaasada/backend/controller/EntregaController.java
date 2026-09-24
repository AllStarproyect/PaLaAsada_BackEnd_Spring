package org.palaasada.backend.controller;

import org.palaasada.backend.model.Entrega;
import org.palaasada.backend.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public ResponseEntity<List<Entrega>> findAll() {
        return ResponseEntity.ok(entregaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> findById(@PathVariable Integer id) {
        return entregaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entrega> save(
            @RequestBody Entrega entrega) {

        return ResponseEntity.ok(entregaService.save(entrega));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrega> update(
            @PathVariable Integer id,
            @RequestBody Entrega entrega) {

        return ResponseEntity.ok(
                entregaService.update(id, entrega)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        entregaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}