package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.Pago;

import org.springframework.stereotype.Repository;
@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
