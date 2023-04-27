package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@Entity
@Table(name = "programas")
public class Programas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrograma")
    private Integer idPrograma;

    @Column(name = "nombrePrograma")
    private String nombrePrograma;

    @Column(name = "descripcionPrograma")
    private String descripcionPrograma;

    @Column(name = "estadoProgramaActivo")
    private Boolean estadoProgramaActivo;

    //Relacion de uno a uno
    @OneToOne
    @JoinColumn(name = "idPeriodoPrograma", referencedColumnName = "idPeriodoPrograma")
    private PeriodoPrograma periodoPrograma;
}
