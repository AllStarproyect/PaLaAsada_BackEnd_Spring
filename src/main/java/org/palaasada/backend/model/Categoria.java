package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @Column(name = "nombre", nullable = false, unique = true, length = 80)
    private String nombre;

    public Categoria() {
    }

    // Getters y Setters
}