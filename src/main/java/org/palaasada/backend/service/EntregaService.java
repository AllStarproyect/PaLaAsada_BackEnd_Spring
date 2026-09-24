package org.palaasada.backend.service;

import org.palaasada.backend.model.Entrega;
import org.palaasada.backend.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public List<Entrega> findAll() {
        return entregaRepository.findAll();
    }

    public Optional<Entrega> findById(Integer id) {
        return entregaRepository.findById(id);
    }

    public Entrega save(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public Entrega update(Integer id, Entrega entrega) {
        entrega.setId(id);
        return entregaRepository.save(entrega);
    }

    public void delete(Integer id) {
        entregaRepository.deleteById(id);
    }
}