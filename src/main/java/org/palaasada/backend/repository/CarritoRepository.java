package org.palaasada.backend.repository;


import org.palaasada.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository {
    //Creacion de métodos abstractos para realizar consultas
    User findByUsername(String username);
    User findByEmail(String email);
}
