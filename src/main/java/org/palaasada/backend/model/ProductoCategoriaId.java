package org.palaasada.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductoCategoriaId implements Serializable {

    private String productoId;

    private Integer categoriaId;

    // Constructor vacío
    public ProductoCategoriaId() {
    }

    // Constructor lleno
    public ProductoCategoriaId(String productoId, Integer categoriaId) {
        this.productoId = productoId;
        this.categoriaId = categoriaId;
    }

    // Getter
    public String getProductoId() {
        return productoId;
    }

    // Setter
    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    // Getter
    public Integer getCategoriaId() {
        return categoriaId;
    }

    // Setter
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    // toString
    @Override
    public String toString() {
        return "ProductoCategoriaId{" +
                "productoId='" + productoId + '\'' +
                ", categoriaId=" + categoriaId +
                '}';
    }
}