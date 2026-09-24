package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.InformacionAdicional;

import org.springframework.stereotype.Repository;
@Repository
public interface InformacionAdicionalRepository extends JpaRepository<InformacionAdicional, String> {
}
