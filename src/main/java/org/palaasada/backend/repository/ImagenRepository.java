package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.Imagen;

import org.springframework.stereotype.Repository;
public interface ImagenRepository extends JpaRepository<Imagen, String>{
}
