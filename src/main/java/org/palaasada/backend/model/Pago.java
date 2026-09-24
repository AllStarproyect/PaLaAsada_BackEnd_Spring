package org.palaasada.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "metodo_pago", length = 40)
    private String metodoPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago", nullable = false)
    private EstadoPago estadoPago = EstadoPago.pendiente;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "referencia_transaccion", length = 120)
    private String referenciaTransaccion;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    //Constructor
    public Pago(Integer id, String metodoPago, EstadoPago estadoPago, BigDecimal monto, LocalDateTime fechaPago, String referenciaTransaccion, Pedido pedido) {
        this.id = id;
        this.metodoPago = metodoPago;
        this.estadoPago = estadoPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.referenciaTransaccion = referenciaTransaccion;
        this.pedido = pedido;
    }

    public Pago() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getReferenciaTransaccion() {
        return referenciaTransaccion;
    }

    public void setReferenciaTransaccion(String referenciaTransaccion) {
        this.referenciaTransaccion = referenciaTransaccion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    //toString
    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", metodoPago='" + metodoPago + '\'' +
                ", estadoPago=" + estadoPago +
                ", monto=" + monto +
                ", fechaPago=" + fechaPago +
                ", referenciaTransaccion='" + referenciaTransaccion + '\'' +
                ", pedido=" + pedido +
                '}';
    }
}