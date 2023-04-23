package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMatricula")
    private Integer idMatricula;

    private LocalDate fechaMatricula;
    private Boolean estadoAporbacion;
    private Boolean estadoMatriculaActivo;

    // SE RELACIONA CON USER Y CURSO

    // RELACIONES
    @ManyToOne
    @JoinColumn(name="idUsuario",referencedColumnName ="idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName ="idCurso")
    private Curso curso;

    //Falta referenciar, FichaMatricula, ParticipantesAprobados
}
