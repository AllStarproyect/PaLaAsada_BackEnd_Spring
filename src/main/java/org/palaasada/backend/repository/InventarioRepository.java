package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.Inventario;

import org.springframework.stereotype.Repository;
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{
}
