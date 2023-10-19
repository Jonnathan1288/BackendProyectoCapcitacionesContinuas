package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "participantesaprobados")
public class ParticipantesAprobados implements Serializable { //estado en  vigencia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participantes_aprobados")
    private Integer idParticipantesAprobados;

    @Column(name = "codigo_senecyt", length = 150)
    private String codigoSenecyt;

    @Column(name = "status")
    private Boolean status;


    // Se relaciona con participantes matriculado
//viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="id_participante_matriculado", referencedColumnName ="id_participante_matriculado")
    private PartipantesMatriculados partipantesMatriculados;
}
