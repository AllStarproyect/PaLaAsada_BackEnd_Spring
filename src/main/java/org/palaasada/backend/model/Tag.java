package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "nombre", nullable = false, unique = true, length = 20)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_asignacion", nullable = false)
    private TipoAsignacion tipoAsignacion;

    @Column(name = "es_promocional", nullable = false)
    private Boolean esPromocional = false;

    public Tag() {
    }

    // Getters y Setters
}
