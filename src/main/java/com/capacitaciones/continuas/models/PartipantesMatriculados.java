package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "partipantesmatriculados")
public class PartipantesMatriculados { //estado en  vigencia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipanteMatriculado")
    private Integer idParticipanteMatriculado;

    private String estadoParticipanteAprobacion;
    private Boolean estadoParticipanteActivo;

    // se referencia con matricula

    @ManyToOne
    @JoinColumn(name="idInscrito",referencedColumnName ="idInscrito")
    private Inscrito inscrito;

    //Flata ref with participantes.. ParticipantesAprobados, Notas, asistencias
}
