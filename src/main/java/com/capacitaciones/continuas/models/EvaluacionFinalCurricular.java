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

    @Column(name = "tecnicaFormativaFinal")
    private String tecnicaFormativaFinal;

    @Column(name = "instrumnetoFormativaFinal")
    private String instrumnetoFormativaFinal;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="idDisenioCurricular",referencedColumnName ="idDisenioCurricular")
    private DisenioCurricular disenioCurricular;

}
