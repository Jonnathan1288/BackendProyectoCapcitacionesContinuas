package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "informefinalcursos")
public class InformeFinalCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInformeFinalCurso")
    private Integer idInformeFinalCurso;

    @Column(name = "observacionesInformeFinalCurso")
    private String observacionesInformeFinalCurso;

    @Column(name = "lugarInformeFinalCurso")
    private String lugarInformeFinalCurso;

    @Column(name = "cantonInformeFinalCurso")
    private String cantonInformeFinalCurso;

    //viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName ="idCurso")
    private Curso curso;


    //Falta la referencai -> detalle final.

}
