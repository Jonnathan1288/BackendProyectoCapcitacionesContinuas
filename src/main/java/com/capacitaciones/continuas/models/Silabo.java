package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "silabos")
public class Silabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSilabo")
    private Integer idSilabo;

    @Column(name = "bibliografia")
    private String bibliografia;

    @Column(name = "campoFormacion")
    private String campoFormacion;

    @Column(name = "campoRevisadoPor")
    private String campoRevisadoPor;

    @Column(name = "campoAprovadoPor")
    private String campoAprovadoPor;

    // Se relaciona con curso

    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName ="idCurso")
    private Curso curso;

    //Falara referencir  con resultado aperesi, contenidosilabos, DisenioCurricular
}
