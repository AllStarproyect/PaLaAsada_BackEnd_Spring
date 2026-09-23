package org.palaasada.backend.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductoTagId implements Serializable {

    private String productoId;

    private Integer tagId;

    public ProductoTagId() {
    }

    public ProductoTagId(String productoId, Integer tagId) {
        this.productoId = productoId;
        this.tagId = tagId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}