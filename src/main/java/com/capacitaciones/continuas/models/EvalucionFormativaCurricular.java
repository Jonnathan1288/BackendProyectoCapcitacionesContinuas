package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "evalucionformativacurriculares")
public class EvalucionFormativaCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvalucionFormativaCurricular")
    private Integer idEvalucionFormativaCurricular;

    private String tecnicaFormativa;
    private String instrumnetoFormativa;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="idMecanismo",referencedColumnName ="idMecanismo")
    private MecanismosEvaluacionCurricular mecanismosEvaluacionCurricular;
}
