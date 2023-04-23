package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "entornoaprendizajescurriculares")
public class EntornoAprendizajeCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntornoCurricular")
    private Integer idEntornoCurricular;

    private String instalaciones;
    private String faseTeorica;
    private String fasePractica ;

    // se relaciona con curriculo
    @ManyToOne
    @JoinColumn(name="idDisenioCurricular",referencedColumnName ="idDisenioCurricular")
    private DisenioCurricular disenioCurricular;
}
