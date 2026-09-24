package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagen")
public class Imagen {

    @Id
    @Column(name = "imagen_id", length = 80)
    private String imagenId;

    @Column(name = "url", columnDefinition = "TEXT")
    private String url;

    @Column(name = "remota", columnDefinition = "TEXT")
    private String remota;

    @Column(name = "local", columnDefinition = "TEXT")
    private String local;

    public Imagen() {
    }

    // Getters y Setters
    public String getImagenId() {
        return imagenId;
    }

    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemota() {
        return remota;
    }

    public void setRemota(String remota) {
        this.remota = remota;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    //toString
    @Override
    public String toString() {
        return "Imagen{" +
                "imagenId='" + imagenId + '\'' +
                ", url='" + url + '\'' +
                ", remota='" + remota + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
