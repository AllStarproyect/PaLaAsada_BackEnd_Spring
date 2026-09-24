package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @Column(name = "inventario_id", length = 80)
    private String inventarioId;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad = 0;

    //Constructor
    public Inventario(String inventarioId, String estado, Integer cantidad) {
        this.inventarioId = inventarioId;
        this.estado = estado;
        this.cantidad = cantidad;
    }

    public Inventario() {
    }

    // Getters y Setters
    public String getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(String inventarioId) {
        this.inventarioId = inventarioId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    //toString
    @Override
    public String toString() {
        return "Inventario{" +
                "inventarioId='" + inventarioId + '\'' +
                ", estado='" + estado + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}