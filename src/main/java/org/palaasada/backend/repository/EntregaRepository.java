package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.Entrega;

import org.springframework.stereotype.Repository;
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
}
