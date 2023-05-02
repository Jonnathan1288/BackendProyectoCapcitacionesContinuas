package com.capacitaciones.continuas.Modelos.Primary;

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

    @Column(name = "estadoActivoCapacitador")
    private Boolean estadoActivoCapacitador;

    @Column(name = "tipoAbreviaturaTitulo")
    private String tipoAbreviaturaTitulo;

    // Referencia con su hoja de vida
    @JsonIgnore
    @OneToOne(mappedBy = "capacitador")
    private HojaVidaCapacitador hojaVidaCapacitador;

    @ManyToOne
    @JoinColumn(name="idUsuario",referencedColumnName ="idUsuario")
    private Usuario usuario;

}
