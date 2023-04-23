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

    private String nombreCurso;
    private String periodoCurso;
    private String tipoCurso;
    private Integer duracionCurso;
    private LocalDate fechaInicioCuros;
    private LocalDate fechaFinCurso;
    private Boolean estadoActivoCurso;
    private String observacionCurso;
    private Boolean estadoCurso;
    private String modalidadCurso;
    private String prerequisitosCurso;
    private String descripcionCurso;
    private String objetivoGeneralesCurso;
    private Integer numeroCuposCurso;

    private String niveles;

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
