package org.palaasada.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "informacion_adicional")
public class InformacionAdicional {

    @Id
    @Column(name = "info_id", length = 80)
    private String infoId;

    @Column(name = "peso", length = 30)
    private String peso;

    @Column(name = "lugar_origen", length = 80)
    private String lugarOrigen;

    @Column(name = "nivel_marmoleado", length = 80)
    private String nivelMarmoleado;

    @Column(name = "maridaje", length = 180)
    private String maridaje;

    //Constructor
    public InformacionAdicional(String infoId, String peso, String lugarOrigen, String nivelMarmoleado, String maridaje) {
        this.infoId = infoId;
        this.peso = peso;
        this.lugarOrigen = lugarOrigen;
        this.nivelMarmoleado = nivelMarmoleado;
        this.maridaje = maridaje;
    }

    public InformacionAdicional() {
    }

    // Getters y Setters
    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public String getNivelMarmoleado() {
        return nivelMarmoleado;
    }

    public void setNivelMarmoleado(String nivelMarmoleado) {
        this.nivelMarmoleado = nivelMarmoleado;
    }

    public String getMaridaje() {
        return maridaje;
    }

    public void setMaridaje(String maridaje) {
        this.maridaje = maridaje;
    }


    //toString
    @Override
    public String toString() {
        return "InformacionAdicional{" +
                "infoId='" + infoId + '\'' +
                ", peso='" + peso + '\'' +
                ", lugarOrigen='" + lugarOrigen + '\'' +
                ", nivelMarmoleado='" + nivelMarmoleado + '\'' +
                ", maridaje='" + maridaje + '\'' +
                '}';
    }
}