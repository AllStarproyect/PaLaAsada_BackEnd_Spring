package org.palaasada.backend.service;

import org.palaasada.backend.model.Precio;
import org.palaasada.backend.repository.PrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecioService {

    @Autowired
    private PrecioRepository precioRepository;

    public List<Precio> findAll() {
        return precioRepository.findAll();
    }

    public Optional<Precio> findById(String id) {
        return precioRepository.findById(id);
    }

    public Precio save(Precio precio) {
        return precioRepository.save(precio);
    }

    public Precio update(String id, Precio precio) {
        precio.setPrecioId(id);
        return precioRepository.save(precio);
    }

    public void delete(String id) {
        precioRepository.deleteById(id);
    }
}