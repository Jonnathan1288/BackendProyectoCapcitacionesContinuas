package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "participantesaprobados")
public class ParticipantesAprobados { //estado en  vigencia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iParticipantesAprobados")
    private Integer idParticipantesAprobados;

    private String codigoSenecyt;

    // Se relaciona con participantes matriculado
    //viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="idParticipanteMatriculado",referencedColumnName ="idParticipanteMatriculado")
    private PartipantesMatriculados partipantesMatriculados;

}
