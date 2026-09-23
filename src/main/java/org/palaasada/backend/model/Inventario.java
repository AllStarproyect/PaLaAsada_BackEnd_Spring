package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @Column(name = "inventario_id", length = 80)
    private String inventarioId;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad = 0;

    public Inventario() {
    }

    // Getters y Setters
}