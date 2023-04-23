package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "capacitadores")
public class Capacitador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCapacitador")
    private Integer idCapacitador;

    @Column(name = "tituloCapacitador")
    private String tituloCapacitador;


    private String abreviatura;

    private Boolean estadoActivoCapacitador;

    // Relacionado con usuario

    // Referencia con su hoja de vida
    @OneToOne(mappedBy = "capacitador", cascade = CascadeType.ALL, orphanRemoval = true)
    private HojaVidaCapacitador hojaVidaCapacitador;

    @ManyToOne
    @JoinColumn(name="idUsuario",referencedColumnName ="idUsuario")
    private Usuario usuario;


}
