package org.palaasada.backend.service;

import org.palaasada.backend.model.Pago;
import org.palaasada.backend.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> findById(Integer id) {
        return pagoRepository.findById(id);
    }

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago update(Integer id, Pago pago) {
        pago.setId(id);
        return pagoRepository.save(pago);
    }

    public void delete(Integer id) {
        pagoRepository.deleteById(id);
    }
}