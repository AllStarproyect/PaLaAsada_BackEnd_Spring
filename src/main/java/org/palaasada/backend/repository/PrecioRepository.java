package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.Precio;

import org.springframework.stereotype.Repository;
@Repository
public interface PrecioRepository extends JpaRepository<Precio, String> {
}
