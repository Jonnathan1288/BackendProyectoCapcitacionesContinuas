package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "detalle_ficha_matriculas")
public class DetalleFichaMatricula { // esta entidad esta en vigencia.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_ficha_matricula")
    private Integer idDetalleFichaMatricula;

    @Column(name = "pregunta1")
    private String pregunta1;

    @Column(name = "pregunta2")
    private String pregunta2;

    @Column(name = "pregunta3")
    private String pregunta3;

    @Column(name = "pregunta4")
    private String pregunta4;

    @Column(name = "pregunta5")
    private String pregunta5;

    @Column(name = "pregunta6")
    private String pregunta6;

    @Column(name = "pregunta7")
    private String pregunta7;

    @Column(name = "pregunta8")
    private String pregunta8;

    @Column(name = "pregunta9")
    private String pregunta9;


    // Se relaciona con la matricula
    //viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="id_ficha_matricula",referencedColumnName ="id_ficha_matricula")
    private FichaMatricula fichaMatricula;
}
