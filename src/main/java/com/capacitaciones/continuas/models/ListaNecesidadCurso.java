package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "listaNecesidadCursos")
public class ListaNecesidadCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idListaNecesidadCursos")
    private Integer idListaNecesidadCursos;

    @Column(name = "detalleNececidadCurso")
    private String detalleNececidadCurso;

    @Column(name = "estadoDetalleNecesidad")
    private Boolean estadoDetalleNecesidad;

    @ManyToOne
    @JoinColumn(name="idNecesidadCurso",referencedColumnName ="idNecesidadCurso")
    private NecesidadCurso necesidadCurso;
    
}
