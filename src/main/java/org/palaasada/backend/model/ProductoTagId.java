package org.palaasada.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductoTagId implements Serializable {

    private String productoId;

    private Integer tagId;

    // Constructor vacío
    public ProductoTagId() {
    }

    // Constructor lleno
    public ProductoTagId(String productoId, Integer tagId) {
        this.productoId = productoId;
        this.tagId = tagId;
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
    public Integer getTagId() {
        return tagId;
    }

    // Setter
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    // toString
    @Override
    public String toString() {
        return "ProductoTagId{" +
                "productoId='" + productoId + '\'' +
                ", tagId=" + tagId +
                '}';
    }


}