package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "evaluacionfinalcurriculares")
public class EvaluacionFinalCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvaluacionFinal")
    private Integer idEvaluacionFinal;

    private String tecnicaFormativaFinal;
    private String instrumnetoFormativaFinal;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="idMecanismo",referencedColumnName ="idMecanismo")
    private MecanismosEvaluacionCurricular mecanismosEvaluacionCurricular;

}
