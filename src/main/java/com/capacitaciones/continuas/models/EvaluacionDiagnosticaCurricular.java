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

    private String tecnicaEvaluar;
    private String instrumnetoEvaluar;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="idMecanismo",referencedColumnName ="idMecanismo")
    private MecanismosEvaluacionCurricular mecanismosEvaluacionCurricular;
}
