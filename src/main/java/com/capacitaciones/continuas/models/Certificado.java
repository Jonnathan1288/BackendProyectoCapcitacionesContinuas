package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "certificados")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCertificado")
    private Integer idCertificado;


    // Se relaciona con participantes aprobados
    @ManyToOne
    @JoinColumn(name="iParticipantesAprobados",referencedColumnName ="iParticipantesAprobados")
    private ParticipantesAprobados participantesAprobados;
}
