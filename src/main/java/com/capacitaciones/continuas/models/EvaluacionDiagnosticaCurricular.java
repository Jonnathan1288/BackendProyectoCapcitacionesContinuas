package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "evaluaciondiagnosticacurriculares")
public class EvaluacionDiagnosticaCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvaluacion")
    private Integer idEvaluacion;

    @Column(name = "tecnicaEvaluar")
    private String tecnicaEvaluar;

    @Column(name = "instrumnetoEvaluar")
    private String instrumnetoEvaluar;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="idDisenioCurricular",referencedColumnName ="idDisenioCurricular")
    private DisenioCurricular disenioCurricular;
}
