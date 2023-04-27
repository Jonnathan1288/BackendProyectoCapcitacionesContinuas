package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsistencia")
    private Integer idAsistencia;

    @Column(name = "fechaAsistencia")
    private LocalDate fechaAsistencia;

    @Column(name = "estadoAsistencia") // Para contavilizar el numero de asistencias por día boolean true: asiste; false:Falta
    private Boolean estadoAsistencia;

    @Column(name = "observacionAsistencia")
    private String observacionAsistencia;

    //Viene la llave idParticipanteMatriculado
    @ManyToOne
    @JoinColumn(name="idParticipanteMatriculado",referencedColumnName ="idParticipanteMatriculado")
    private PartipantesMatriculados partipantesMatriculados;

}
