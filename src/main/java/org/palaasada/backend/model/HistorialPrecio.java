package org.palaasada.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_precio")
public class HistorialPrecio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historial_id")
    private Integer historialId;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "precio_anterior", precision = 10, scale = 2)
    private BigDecimal precioAnterior;

    @Column(name = "precio_nuevo", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioNuevo;

    @Column(name = "fecha_cambio", nullable = false)
    private LocalDateTime fechaCambio = LocalDateTime.now();

    // Constructor
    public HistorialPrecio(Integer historialId, Producto producto, BigDecimal precioAnterior, BigDecimal precioNuevo, LocalDateTime fechaCambio) {
        this.historialId = historialId;
        this.producto = producto;
        this.precioAnterior = precioAnterior;
        this.precioNuevo = precioNuevo;
        this.fechaCambio = fechaCambio;
    }

    public HistorialPrecio() {
    }

    // Getters y Setters
    public Integer getHistorialId() {
        return historialId;
    }

    public void setHistorialId(Integer historialId) {
        this.historialId = historialId;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecioAnterior() {
        return precioAnterior;
    }

    public void setPrecioAnterior(BigDecimal precioAnterior) {
        this.precioAnterior = precioAnterior;
    }

    public BigDecimal getPrecioNuevo() {
        return precioNuevo;
    }

    public void setPrecioNuevo(BigDecimal precioNuevo) {
        this.precioNuevo = precioNuevo;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    // toString
    @Override
    public String toString() {
        return "HistorialPrecio{" +
                "historialId=" + historialId +
                ", producto=" + producto +
                ", precioAnterior=" + precioAnterior +
                ", precioNuevo=" + precioNuevo +
                ", fechaCambio=" + fechaCambio +
                '}';
    }
}