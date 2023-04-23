package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "detalleevaluacionfinales")
public class DetalleEvaluacionFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleEvaluacionFinal")
    private Integer idDetalleEvaluacionFinal;

    //Preguntas para el profesor

    @Column(name = "preguntaProfesor1")
    private String preguntaProfesor1;

    @Column(name = "preguntaProfesor2")
    private String preguntaProfesor2;

    @Column(name = "preguntaProfesor3")
    private String preguntaProfesor3;

    @Column(name = "preguntaProfesor4")
    private String preguntaProfesor4;

    @Column(name = "preguntaProfesor5")
    private String preguntaProfesor5;

    //Preguntas para contenidos
    @Column(name = "preguntaContenido1")
    private String preguntaContenido1;

    @Column(name = "preguntaContenido2")
    private String preguntaContenido2;

    @Column(name = "preguntaContenido3")
    private String preguntaContenido3;

    //Preguntas para metodologia
    @Column(name = "preguntaMetodologia1")
    private String preguntaMetodologia1;

    @Column(name = "preguntaMetodologia2")
    private String preguntaMetodologia2;

    //Preguntas para logistica
    @Column(name = "preguntaLogistica1")
    private String preguntaLogistica1;

    @Column(name = "preguntaLogistica2")
    private String preguntaLogistica2;

    @Column(name = "preguntaLogistica3")
    private String preguntaLogistica3;

    //Preguntas para autoevaluacion
    @Column(name = "preguntaAtoevaluacion1")
    private String preguntaAtoevaluacion1;

    @Column(name = "preguntaAtoevaluacion2")
    private String preguntaAtoevaluacion2;

    @Column(name = "preguntaAtoevaluacion3")
    private String preguntaAtoevaluacion3;

    //Temas de inters
    @Column(name = "temaInteres")
    private String temaInteres;

    //Relacion con informe final curso
    @ManyToOne
    @JoinColumn(name="idInformeFinalCurso",referencedColumnName ="idInformeFinalCurso")
    private InformeFinalCurso informeFinalCurso;

}
