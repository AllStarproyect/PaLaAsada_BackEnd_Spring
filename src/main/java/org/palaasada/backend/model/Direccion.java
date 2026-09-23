package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "calle", nullable = false, length = 150)
    private String calle;

    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    @Column(name = "colonia", nullable = false, length = 100)
    private String colonia;

    @Column(name = "municipio", nullable = false, length = 100)
    private String municipio;

    @Column(name = "estado", nullable = false, length = 100)
    private String estado;

    @Column(name = "codigo_postal", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "referencias", length = 255)
    private String referencias;

    @Column(name = "predeterminada", nullable = false)
    private Boolean predeterminada = false;

    public Direccion() {
    }

    // Getters y Setters
}