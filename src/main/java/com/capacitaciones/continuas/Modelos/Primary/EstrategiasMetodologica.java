package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "estrategiasmetodologicas")
public class EstrategiasMetodologica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estrategia_metodologica")
    private Integer idEstrategiaMetodologica;

    @Column(name = "nombre_estrategia_metodologica")
    private String nombreEstrategiaMetodologica;

    @Column(name = "finalidad_estrategia_metodologica")
    private String finalidadEstrategiaMetodologica;

    @Column(name = "estado_estrategia_metodologicaActivo")
    private Boolean estadoEstrategiaMetodologicaActivo;

    @ManyToOne
    @JoinColumn(name="id_silabo",referencedColumnName ="id_silabo")
    private Silabo silabo;

}
