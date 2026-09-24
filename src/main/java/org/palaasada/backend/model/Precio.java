package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "precio")
public class Precio {

    @Id
    @Column(name = "precio_id", length = 80)
    private String precioId;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private Double monto;

    @Column(name = "moneda", length = 3)
    private String moneda;

    @Column(name = "texto", length = 40)
    private String texto;

    @Column(name = "nota", columnDefinition = "TEXT")
    private String nota;

    //Constructor


    public Precio(String precioId, Double monto, String moneda, String texto, String nota) {
        this.precioId = precioId;
        this.monto = monto;
        this.moneda = moneda;
        this.texto = texto;
        this.nota = nota;
    }

    public Precio() {
    }

    // Getters y Setters

    public String getPrecioId() {
        return precioId;
    }

    public void setPrecioId(String precioId) {
        this.precioId = precioId;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }


    //toString
    @Override
    public String toString() {
        return "Precio{" +
                "precioId='" + precioId + '\'' +
                ", monto=" + monto +
                ", moneda='" + moneda + '\'' +
                ", texto='" + texto + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
