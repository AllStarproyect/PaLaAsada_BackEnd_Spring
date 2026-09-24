package org.palaasada.backend.controller;

import org.palaasada.backend.model.Inventario;
import org.palaasada.backend.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> findAll() {
        return ResponseEntity.ok(inventarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> findById(@PathVariable String id) {
        return inventarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventario> save(
            @RequestBody Inventario inventario) {

        return ResponseEntity.ok(
                inventarioService.save(inventario)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> update(
            @PathVariable String id,
            @RequestBody Inventario inventario) {

        return ResponseEntity.ok(
                inventarioService.update(id, inventario)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        inventarioService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
