package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.HistorialInventario;

import org.springframework.stereotype.Repository;
@Repository
public interface HistorialInventarioRepository extends JpaRepository<HistorialInventario, Integer> {
}
