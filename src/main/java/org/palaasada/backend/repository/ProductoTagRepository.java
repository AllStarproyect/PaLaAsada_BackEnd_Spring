package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.ProductoTag;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductoTagRepository extends JpaRepository<ProductoTag, Integer>{
}
