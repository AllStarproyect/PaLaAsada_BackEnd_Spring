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

    public Entrega() {
    }

    // Getters y Setters
}