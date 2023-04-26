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


    @Column(name = "fechaInicioPrograma")
    private LocalDate fechaInicioPrograma;

    @Column(name = "fechaFinPrograma")
    private LocalDate fechaFinPrograma;

    @Column(name = "obervacionPrograma")
    private String obervacionPrograma;

    @Column(name = "estadoProgramaActivo")
    private Boolean estadoProgramaActivo;

    // Relacionado con usuario
    @ManyToOne
    @JoinColumn(name="idUsuario",referencedColumnName ="idUsuario")
    private Usuario usuario;

    //Relacion de uno a uno
    @OneToOne
    @JoinColumn(name = "idPeriodoPrograma", referencedColumnName = "idPeriodoPrograma")
    private PeriodoPrograma periodoCurso;
}
