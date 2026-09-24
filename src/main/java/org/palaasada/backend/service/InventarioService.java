package org.palaasada.backend.service;

import org.palaasada.backend.model.Inventario;
import org.palaasada.backend.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {


    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> findById(String id) {
        return inventarioRepository.findById(id);
    }

    public Inventario save(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario update(String id, Inventario inventario) {
        inventario.setInventarioId(id);
        return inventarioRepository.save(inventario);
    }

    public void delete(String id) {
        inventarioRepository.deleteById(id);
    }
}
