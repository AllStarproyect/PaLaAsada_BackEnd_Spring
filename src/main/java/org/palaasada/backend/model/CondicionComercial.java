package org.palaasada.backend.model;

import jakarta.persistence.*;
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
    private Double precioPromocional;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    public CondicionComercial() {
    }

    // Getters y Setters
}
