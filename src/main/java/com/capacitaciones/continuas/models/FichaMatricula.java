package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "fichamatriculas")
public class FichaMatricula { // esta entidad esta en vigencia.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFichaMatricula")
    private Integer idFichaMatricula;

    private String informacion1;
    private String informacion2;
    private String informacion3;
    private String informacion4;
    private String informacion5;
    private String informacion6;
    private String informacion7;
    private String informacion8;
    private String informacion9;

    // Se relaciona con la matricula
    //viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="idInscrito",referencedColumnName ="idInscrito")
    private Inscrito inscrito;
}
