package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "evaluacion_diagnostica_curriculares")
public class EvaluacionDiagnosticaCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacionDiagnostica_curricular")
    private Integer idEvaluacionDiagnosticaCurricular;

    @Column(name = "tecnica_evaluar")
    private String tecnicaEvaluar;

    @Column(name = "instrumneto_evaluar")
    private String instrumnetoEvaluar;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="id_disenio_curricular",referencedColumnName ="id_disenio_curricular")
    private DisenioCurricular disenioCurricular;
}
