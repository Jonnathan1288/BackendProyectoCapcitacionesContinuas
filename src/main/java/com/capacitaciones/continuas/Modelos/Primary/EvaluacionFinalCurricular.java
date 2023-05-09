package com.capacitaciones.continuas.Modelos.Primary;

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
    @Column(name = "id_evaluacion_final")
    private Integer idEvaluacionFinal;

    @Column(name = "tecnica_formativa_final")
    private String tecnicaFormativaFinal;

    @Column(name = "instrumneto_formativa_final")
    private String instrumnetoFormativaFinal;

    @Column(name = "estadoEvaluacionFinal")
    private Boolean estadoEvaluacionFinal;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="id_disenio_curricular",referencedColumnName ="id_disenio_curricular")
    private DisenioCurricular disenioCurricular;

}
