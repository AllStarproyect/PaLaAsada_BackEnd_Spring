package org.palaasada.backend.service;

import org.palaasada.backend.model.Carrito;
import org.palaasada.backend.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> findAll() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> findById(Integer id) {
        return carritoRepository.findById(id);
    }

    public Carrito save(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Carrito update(Integer id, Carrito carrito) {
        carrito.setId(id);
        return carritoRepository.save(carrito);
    }

    public void delete(Integer id) {
        carritoRepository.deleteById(id);
    }
}