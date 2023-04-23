package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "controlhorarios")
public class ControlHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idControlHorario")
    private Integer idControlHorario;

    @Column(name = "dia")
    private String dia;

    @Column(name = "horaInicio")
    private String horaInicio;

    @Column(name = "horaFin")
    private String horaFin;

    @Column(name = "estadoControl")
    private Boolean estadoControl;

    //Viene la referencia de horario cursos

    @JsonIgnore
    @OneToMany(mappedBy = "controlHorario")
    private List<HorarioCurso> horarioCursos;
}
