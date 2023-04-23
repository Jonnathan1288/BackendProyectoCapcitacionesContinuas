package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "partipantesmatriculados")
public class PartipantesMatriculados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipanteMatriculado")
    private Integer idParticipanteMatriculado;

    private String estadoParticipanteAprobacion;
    private Boolean estadoParticipanteActivo;


    // se referencia con matricula

    @ManyToOne
    @JoinColumn(name="idMatricula",referencedColumnName ="idMatricula")
    private Matricula matricula;

    //Flata ref with participantes.. ParticipantesAprobados, Notas, asistencias
}
