package org.palaasada.backend.service;

import org.palaasada.backend.model.Producto;
import org.palaasada.backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(String id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(String id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    public void delete(String id) {
        productoRepository.deleteById(id);
    }
}