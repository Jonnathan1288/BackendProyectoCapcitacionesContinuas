package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "especialidades")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidad")
    private Integer idEspecialidad;

    private String codigoEspecialidad;
    private String nombreEspecialidad;
    private Boolean estadoEspecialidadActivo;

    // RELACION
    @ManyToOne
    @JoinColumn(name="idArea",referencedColumnName ="idArea")
    private Area area;

}
