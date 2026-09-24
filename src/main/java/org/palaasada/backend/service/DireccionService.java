package org.palaasada.backend.service;

import org.palaasada.backend.model.Direccion;
import org.palaasada.backend.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    public Optional<Direccion> findById(Integer id) {
        return direccionRepository.findById(id);
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public Direccion update(Integer id, Direccion direccion) {
        direccion.setId(id);
        return direccionRepository.save(direccion);
    }

    public void delete(Integer id) {
        direccionRepository.deleteById(id);
    }
}