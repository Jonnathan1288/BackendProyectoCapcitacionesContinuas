package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "horarioscursos")
public class HorarioCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorarioCurso")
    private Integer idHorarioCurso;

    @Column(name = "estadoHorarioCurso")
    private Boolean estadoHorarioCurso;

    //Viene la llave idcurso
    //Relacion con control horario

    @ManyToOne
    @JoinColumn(name="idControlHorario",referencedColumnName ="idControlHorario")
    private ControlHorario controlHorario;

    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName ="idCurso")
    private Curso curso;
}
