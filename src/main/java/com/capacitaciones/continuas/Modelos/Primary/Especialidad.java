package com.capacitaciones.continuas.Modelos.Primary;

import com.capacitaciones.continuas.Modelos.Primary.Area;
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

    @Column(name = "codigoEspecialidad")
    private String codigoEspecialidad;

    @Column(name = "nombreEspecialidad")
    private String nombreEspecialidad;

    @Column(name = "estadoEspecialidadActivo")
    private Boolean estadoEspecialidadActivo;

    // RELACION
    @ManyToOne
    @JoinColumn(name="idArea",referencedColumnName ="idArea")
    private Area area;

}
