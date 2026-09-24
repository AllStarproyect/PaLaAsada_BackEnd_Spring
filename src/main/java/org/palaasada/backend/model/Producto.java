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

    //Constructor
    public Producto(String id, String sku, String nombre, Boolean tieneVariantes, String descripcion, Precio precio, Inventario inventario, Imagen imagen, InformacionAdicional informacionAdicional, Categoria categoriaPrincipal) {
        this.id = id;
        this.sku = sku;
        this.nombre = nombre;
        this.tieneVariantes = tieneVariantes;
        this.descripcion = descripcion;
        this.precio = precio;
        this.inventario = inventario;
        this.imagen = imagen;
        this.informacionAdicional = informacionAdicional;
        this.categoriaPrincipal = categoriaPrincipal;
    }

    public Producto() {
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTieneVariantes() {
        return tieneVariantes;
    }

    public void setTieneVariantes(Boolean tieneVariantes) {
        this.tieneVariantes = tieneVariantes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public Categoria getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    public void setCategoriaPrincipal(Categoria categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }


    //toString
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tieneVariantes=" + tieneVariantes +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", inventario=" + inventario +
                ", imagen=" + imagen +
                ", informacionAdicional=" + informacionAdicional +
                ", categoriaPrincipal=" + categoriaPrincipal +
                '}';
    }
}