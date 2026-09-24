package org.palaasada.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "condicion_comercial")
public class CondicionComercial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condicion_id")
    private Integer condicionId;

    @Column(name = "producto_id", nullable = false, length = 80)
    private String productoId;

    @Column(name = "tag_id", nullable = false)
    private Integer tagId;

    @Column(name = "precio_promocional", precision = 10, scale = 2)
    private BigDecimal precioPromocional;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    // Constructor
    public CondicionComercial(Integer condicionId, String productoId, Integer tagId, BigDecimal precioPromocional, LocalDate fechaInicio, LocalDate fechaFin) {
        this.condicionId = condicionId;
        this.productoId = productoId;
        this.tagId = tagId;
        this.precioPromocional = precioPromocional;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public CondicionComercial() {
    }

    // Getters y Setters
    public Integer getCondicionId() {
        return condicionId;
    }

    public void setCondicionId(Integer condicionId) {
        this.condicionId = condicionId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public BigDecimal getPrecioPromocional() {
        return precioPromocional;
    }

    public void setPrecioPromocional(BigDecimal precioPromocional) {
        this.precioPromocional = precioPromocional;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // toString
    @Override
    public String toString() {
        return "CondicionComercial{" +
                "condicionId=" + condicionId +
                ", productoId='" + productoId + '\'' +
                ", tagId=" + tagId +
                ", precioPromocional=" + precioPromocional +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}