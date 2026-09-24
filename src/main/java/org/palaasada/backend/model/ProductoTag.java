package org.palaasada.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "producto_tag")
public class ProductoTag {

    @EmbeddedId
    private ProductoTagId id;

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion;

    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    //Constructor
    public ProductoTag(ProductoTagId id, Producto producto, Tag tag, LocalDateTime fechaAsignacion, LocalDateTime fechaExpiracion) {
        this.id = id;
        this.producto = producto;
        this.tag = tag;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaExpiracion = fechaExpiracion;
    }

    public ProductoTag() {
    }

    //Getter y Setter
    public ProductoTagId getId() {
        return id;
    }

    public void setId(ProductoTagId id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    //toString
    @Override
    public String toString() {
        return "ProductoTag{" +
                "id=" + id +
                ", producto=" + producto +
                ", tag=" + tag +
                ", fechaAsignacion=" + fechaAsignacion +
                ", fechaExpiracion=" + fechaExpiracion +
                '}';
    }
}