package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productocategoria")
public class ProductoCategoria {

    @EmbeddedId
    private ProductoCategoriaId id;

    public ProductoCategoria() {
    }

    public ProductoCategoriaId getId() {
        return id;
    }

    public void setId(ProductoCategoriaId id) {
        this.id = id;
    }
}

