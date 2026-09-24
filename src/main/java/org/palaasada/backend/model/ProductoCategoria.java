package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productocategoria")
public class ProductoCategoria {

    @EmbeddedId
    private ProductoCategoriaId id;

    // Constructor vacío
    public ProductoCategoria() {
    }

    // Constructor lleno
    public ProductoCategoria(ProductoCategoriaId id) {
        this.id = id;
    }

    // Getter
    public ProductoCategoriaId getId() {
        return id;
    }

    // Setter
    public void setId(ProductoCategoriaId id) {
        this.id = id;
    }

    // toString
    @Override
    public String toString() {
        return "ProductoCategoria{" +
                "id=" + id +
                '}';
    }
}