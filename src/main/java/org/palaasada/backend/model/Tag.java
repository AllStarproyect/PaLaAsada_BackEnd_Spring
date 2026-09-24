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

    //Constructor


    public Tag(Integer tagId, String nombre, TipoAsignacion tipoAsignacion, Boolean esPromocional) {
        this.tagId = tagId;
        this.nombre = nombre;
        this.tipoAsignacion = tipoAsignacion;
        this.esPromocional = esPromocional;
    }

    public Tag() {
    }

    // Getters y Setters

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoAsignacion getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(TipoAsignacion tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
    }

    public Boolean getEsPromocional() {
        return esPromocional;
    }

    public void setEsPromocional(Boolean esPromocional) {
        this.esPromocional = esPromocional;
    }


    //toString
    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", nombre='" + nombre + '\'' +
                ", tipoAsignacion=" + tipoAsignacion +
                ", esPromocional=" + esPromocional +
                '}';
    }
}
