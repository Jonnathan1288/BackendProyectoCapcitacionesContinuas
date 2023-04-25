package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "estrategiasMetodologicas")
public class EstrategiasMetodologica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstrategiaMetodologica")
    private Integer idEstrategiaMetodologica;

    @Column(name = "nombreEstrategiaMetodologica")
    private String nombreEstrategiaMetodologica;

    @Column(name = "finalidadEstrategiaMetodologica")
    private String finalidadEstrategiaMetodologica;

    @ManyToOne
    @JoinColumn(name="idSilabo",referencedColumnName ="idSilabo")
    private Silabo silabo;
}
