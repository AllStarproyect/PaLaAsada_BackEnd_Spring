package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true, length = 150)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    //Constructor
    public User(Integer id, String nombre, String correo, String telefono, String password, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.activo = activo;
    }

    public User() {
    }

    // Getters y Setters
}