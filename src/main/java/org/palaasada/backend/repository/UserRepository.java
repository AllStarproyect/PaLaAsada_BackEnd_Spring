package org.palaasada.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.palaasada.backend.model.User;

import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
