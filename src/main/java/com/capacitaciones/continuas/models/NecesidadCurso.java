package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "necesidadescursos")
public class NecesidadCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNecesidadCurso")
    private Integer idNecesidadCurso;

    @Column(name = "estadoImpartirNecesidadCurso")
    private String espacioImpartirNecesidadCurso;

    @Column(name = "resumenCurso")
    private String resumenCurso;

    @Column(name = "poblacionDirijida")
    private String poblacionDirijida;

    //Viene la llave de id curso

    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName ="idCurso")
    private Curso curso;
    //

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "necesidadCurso")
    private List<ListaNecesidadCurso> listaNecesidadCursos;
}
