package org.palaasada.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "precio")
public class Precio {

    @Id
    @Column(name = "precio_id", length = 80)
    private String precioId;

    // Se cambia a BigDecimal con precision y scale válidos
    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "moneda", length = 3)
    private String moneda;

    @Column(name = "texto", length = 40)
    private String texto;

    @Column(name = "nota", columnDefinition = "TEXT")
    private String nota;

    // Constructor vacío exigido por JPA
    public Precio() {
    }

    // Constructor completo
    public Precio(String precioId, BigDecimal monto, String moneda, String texto, String nota) {
        this.precioId = precioId;
        this.monto = monto;
        this.moneda = moneda;
        this.texto = texto;
        this.nota = nota;
    }

    // Getters y Setters

    public String getPrecioId() {
        return precioId;
    }

    public void setPrecioId(String precioId) {
        this.precioId = precioId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
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

    // toString
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