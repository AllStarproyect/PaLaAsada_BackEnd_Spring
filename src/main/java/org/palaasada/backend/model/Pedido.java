package org.palaasada.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPedido estado = EstadoPedido.pendiente;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(name = "envio", nullable = false, precision = 10, scale = 2)
    private BigDecimal envio = BigDecimal.ZERO;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    //Constructor
    public Pedido(Integer id, EstadoPedido estado, LocalDateTime fechaCreacion, BigDecimal subtotal, BigDecimal envio, BigDecimal total, User usuario) {
        this.id = id;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.subtotal = subtotal;
        this.envio = envio;
        this.total = total;
        this.usuario = usuario;
    }

    public Pedido() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getEnvio() {
        return envio;
    }

    public void setEnvio(BigDecimal envio) {
        this.envio = envio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
        return "Pedido{" +
                "id=" + id +
                ", estado=" + estado +
                ", fechaCreacion=" + fechaCreacion +
                ", subtotal=" + subtotal +
                ", envio=" + envio +
                ", total=" + total +
                ", usuario=" + usuario +
                '}';
    }
}