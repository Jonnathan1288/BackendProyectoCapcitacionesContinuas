package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "notas")
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNota")
    private Integer idNota;

    @Column(name = "parcial")
    private Integer parcial;

    @Column(name = "examenFinal")
    private Integer examenFinal;

    @Column(name = "fechaNota")
    private LocalDate fechaNota;

    @Column(name = "observacion")
    private String observacion;

    // se relacioina con el estudiante matriculado
    @ManyToOne
    @JoinColumn(name="idParticipanteMatriculado",referencedColumnName ="idParticipanteMatriculado")
    private PartipantesMatriculados partipantesMatriculados;


}
