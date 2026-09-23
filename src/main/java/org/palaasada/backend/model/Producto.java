package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "id", length = 80)
    private String id;

    @Column(name = "sku", nullable = false, unique = true, length = 80)
    private String sku;

    @Column(name = "nombre", nullable = false, length = 180)
    private String nombre;

    @Column(name = "tieneVariantes")
    private Boolean tieneVariantes;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "precio_id")
    private Precio precio;

    @ManyToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    @ManyToOne
    @JoinColumn(name = "info_adicional_id")
    private InformacionAdicional informacionAdicional;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_principal_id", nullable = false)
    private Categoria categoriaPrincipal;

    public Producto() {
    }

    // Getters y Setters
}