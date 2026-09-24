package org.palaasada.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.DetallePedido;

import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedidoRepository, Integer> {
}
