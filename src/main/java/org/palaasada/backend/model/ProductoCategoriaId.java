package org.palaasada.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductoCategoriaId implements Serializable {

    private String productoId;

    private Integer categoriaId;

    public ProductoCategoriaId() {
    }

    public ProductoCategoriaId(String productoId, Integer categoriaId) {
        this.productoId = productoId;
        this.categoriaId = categoriaId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
}