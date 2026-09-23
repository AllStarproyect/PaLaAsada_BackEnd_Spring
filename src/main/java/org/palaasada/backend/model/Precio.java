package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "precio")
public class Precio {

    @Id
    @Column(name = "precio_id", length = 80)
    private String precioId;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private Double monto;

    @Column(name = "moneda", length = 3)
    private String moneda;

    @Column(name = "texto", length = 40)
    private String texto;

    @Column(name = "nota", columnDefinition = "TEXT")
    private String nota;

    public Precio() {
    }

    // Getters y Setters
}
