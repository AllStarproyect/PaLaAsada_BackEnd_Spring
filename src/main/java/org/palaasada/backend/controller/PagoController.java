package org.palaasada.backend.controller;

import org.palaasada.backend.model.Pago;
import org.palaasada.backend.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> findAll() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> findById(@PathVariable Integer id) {
        return pagoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pago> save(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.save(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(
            @PathVariable Integer id,
            @RequestBody Pago pago) {

        return ResponseEntity.ok(
                pagoService.update(id, pago)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        pagoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}