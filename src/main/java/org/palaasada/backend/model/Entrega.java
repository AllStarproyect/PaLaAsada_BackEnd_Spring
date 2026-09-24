package org.palaasada.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "direccion_id", nullable = false)
    private Direccion direccion;

    @Column(name = "fecha_programada")
    private LocalDate fechaProgramada;

    @Column(name = "rango_horario", length = 40)
    private String rangoHorario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_entrega", nullable = false)
    private TipoEntrega tipoEntrega = TipoEntrega.domicilio;

    @Column(name = "fecha_hora_entregado")
    private LocalDateTime fechaHoraEntregado;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    //Constructor
    public Entrega(Integer id, Direccion direccion, LocalDate fechaProgramada, String rangoHorario, TipoEntrega tipoEntrega, LocalDateTime fechaHoraEntregado, Pedido pedido) {
        this.id = id;
        this.direccion = direccion;
        this.fechaProgramada = fechaProgramada;
        this.rangoHorario = rangoHorario;
        this.tipoEntrega = tipoEntrega;
        this.fechaHoraEntregado = fechaHoraEntregado;
        this.pedido = pedido;
    }

    public Entrega() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getRangoHorario() {
        return rangoHorario;
    }

    public void setRangoHorario(String rangoHorario) {
        this.rangoHorario = rangoHorario;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public LocalDateTime getFechaHoraEntregado() {
        return fechaHoraEntregado;
    }

    public void setFechaHoraEntregado(LocalDateTime fechaHoraEntregado) {
        this.fechaHoraEntregado = fechaHoraEntregado;
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
        return "Entrega{" +
                "id=" + id +
                ", direccion=" + direccion +
                ", fechaProgramada=" + fechaProgramada +
                ", rangoHorario='" + rangoHorario + '\'' +
                ", tipoEntrega=" + tipoEntrega +
                ", fechaHoraEntregado=" + fechaHoraEntregado +
                ", pedido=" + pedido +
                '}';
    }
}