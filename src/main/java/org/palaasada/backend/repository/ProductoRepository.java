package org.palaasada.backend.repository;

import org.palaasada.backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>{

    //Creacion de métodos abstractos para realizar consultas
    Producto findByNombre(String nombre);
}






