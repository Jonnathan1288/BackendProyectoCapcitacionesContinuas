package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "mecanismosevaluacioncurriculares")
public class MecanismosEvaluacionCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMecanismo")
    private Integer idMecanismo;


    // relaciona con con el el id del curriculo
    @ManyToOne
    @JoinColumn(name="idDisenioCurricular",referencedColumnName ="idDisenioCurricular")
    private DisenioCurricular disenioCurricular;

    // 3 referencia con las tablas evaDiag, evaluacionProceso, evaluFinal
}
