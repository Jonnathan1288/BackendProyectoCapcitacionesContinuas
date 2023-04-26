package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "abreviaturasTitulos")
public class AbreviaturaTitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAbreviaturaTitulo")
    private Integer idAbreviaturaTitulo;

    @Column(name = "estadoAbreviaturaTitulo")
    private Boolean estadoAbreviaturaTitulo;

    @Column(name = "nombreAbreviaturaTitulo")
    private String nombreAbreviaturaTitulo;

    @JsonIgnore
    @OneToOne(mappedBy = "tipoCurso")
    private Curso curso;

    @JsonIgnore
    @OneToOne(mappedBy = "abreviaturaTitulo")
    private Capacitador capacitador;

}
