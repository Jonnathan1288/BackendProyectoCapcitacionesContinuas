package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "diseniocurriculares")
public class DisenioCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDisenioCurricular")
    private Integer idCDisenioCurricular;

    private String temasTransversales;
    private String estrategiasAprendizaje;

    // RELACIONAR CON EL SILABO
    @ManyToOne
    @JoinColumn(name="idSilabo",referencedColumnName ="idSilabo")
    private Silabo silabo;

    //Falta refe -> EntornoAprendizajeCurricular, MecanismosEvaluacionCurricular
}
