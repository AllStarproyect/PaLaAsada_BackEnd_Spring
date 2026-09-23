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

    public InformacionAdicional() {
    }

    // Getters y Setters
}