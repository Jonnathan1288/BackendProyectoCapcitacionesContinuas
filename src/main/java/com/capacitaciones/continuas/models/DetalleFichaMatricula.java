package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "detallefichamatriculas")
public class DetalleFichaMatricula { // esta entidad esta en vigencia.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleFichaMatricula")
    private Integer idDetalleFichaMatricula;

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
    @JoinColumn(name="idFichaMatricula",referencedColumnName ="idFichaMatricula")
    private FichaMatricula fichaMatricula;
}
