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

    @Column(name = "tecnicaFormativa")
    private String tecnicaFormativa;

    @Column(name = "instrumnetoFormativa")
    private String instrumnetoFormativa;

    @Column(name = "estadoEvaluacionFormativa")
    private Boolean estadoEvaluacionFormativa;
    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="idDisenioCurricular",referencedColumnName ="idDisenioCurricular")
    private DisenioCurricular disenioCurricular;
}
