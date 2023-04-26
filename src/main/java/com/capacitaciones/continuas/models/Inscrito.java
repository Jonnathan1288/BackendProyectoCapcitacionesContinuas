package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "inscritos")
public class Inscrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInscrito")
    private Integer idInscrito;

    @Column(name = "fechaInscrito")
    private LocalDate fechaInscrito;

    @Column(name = "estadoInscrito")
    private Boolean estadoInscrito;

    @Column(name = "estadoInscritoActivo")
    private Boolean estadoInscritoActivo;

    // SE RELACIONA CON USER Y CURSO

    // RELACIONES
    @ManyToOne
    @JoinColumn(name="idUsuario",referencedColumnName ="idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName ="idCurso")
    private Curso curso;

    //Falta referenciar, FichaMatricula, ParticipantesAprobados

    @JsonIgnore
    @OneToMany(mappedBy = "inscrito")
    private List<PartipantesMatriculados> partipantesMatriculados;

    @JsonIgnore
    @OneToMany(mappedBy = "inscrito")
    private List<FichaMatricula> fichaMatriculas;
}
