package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagen")
public class Imagen {

    @Id
    @Column(name = "imagen_id", length = 80)
    private String imagenId;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @Column(name = "remota", columnDefinition = "TEXT")
    private String remota;

    @Column(name = "local", columnDefinition = "TEXT")
    private String local;

    public Imagen() {
    }

    // Getters y Setters
}
