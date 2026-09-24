package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    //Constructor
    public Carrito(Integer id, User usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Carrito() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    //toString
    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", usuario=" + usuario +
                '}';
    }
}