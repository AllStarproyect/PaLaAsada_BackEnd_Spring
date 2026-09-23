package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.HistorialPrecio;

import org.springframework.stereotype.Repository;
public interface HistorialPrecioRepository extends JpaRepository<HistorialPrecio, Integer> {
}
