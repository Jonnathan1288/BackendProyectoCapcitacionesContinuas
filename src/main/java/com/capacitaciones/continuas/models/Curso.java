package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurso")
    private Integer idCurso;

    @Column(name = "nombreCurso")
    private String nombreCurso;

    @Column(name = "periodoCurso")
    private String periodoCurso;

    @Column(name = "tipoCurso")
    private String tipoCurso;

    @Column(name = "fotoCurso")
    private String fotoCurso;

    @Column(name = "duracionCurso")
    private Integer duracionCurso;

    @Column(name = "fechaInicioCuros")
    private LocalDate fechaInicioCuros;

    @Column(name = "fechaFinCurso")
    private LocalDate fechaFinCurso;

    @Column(name = "observacionCurso")
    private String observacionCurso;

    @Column(name = "estadoCurso")
    private Boolean estadoCurso; // Elimina curso logico

    @Column(name = "estadoAprovacionCurso")
    private String estadoAprovacionCurso; //aprovacion del curso // N = NO NO APROVADO, A = APROVADO, P = PENDIENTE

    @Column(name = "estadoPublicasionCurso")
    private Boolean estadoPublicasionCurso; // para el usuario

    @Column(name = "modalidadCurso")
    private String modalidadCurso;

    @Column(name = "prerequisitosCurso")
    private String prerequisitosCurso;

    @Column(name = "descripcionCurso")
    private String descripcionCurso;

    @Column(name = "objetivoGeneralesCurso")
    private String objetivoGeneralesCurso;

    @Column(name = "numeroCuposCurso")
    private Integer numeroCuposCurso;

    @Column(name = "niveles")
    private String niveles; //

    //Viene la lave de idprograma
    @ManyToOne
    @JoinColumn(name="idPrograma",referencedColumnName ="idPrograma")
    private Programas programas;

    //Viene la lave de idEspecialida
    @ManyToOne
    @JoinColumn(name="idEspecialidad",referencedColumnName ="idEspecialidad")
    private Especialidad especialidad;

    //Viene la lave de idCapacitador
    @ManyToOne
    @JoinColumn(name="idCapacitador",referencedColumnName ="idCapacitador")
    private Capacitador capacitador;


    //Falta todas las referencias..

}
