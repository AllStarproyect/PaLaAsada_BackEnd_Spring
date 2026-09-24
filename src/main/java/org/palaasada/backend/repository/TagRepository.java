package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.Tag;

import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
