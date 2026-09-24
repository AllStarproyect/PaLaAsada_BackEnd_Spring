package org.palaasada.backend.service;

import org.palaasada.backend.model.Pedido;
import org.palaasada.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Integer id, Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    public void delete(Integer id) {
        pedidoRepository.deleteById(id);
    }
}