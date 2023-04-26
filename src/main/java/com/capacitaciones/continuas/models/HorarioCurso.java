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
public class HorarioCurso { //entidad en vigencia.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHorarioCurso")
    private Integer idHorarioCurso;

    @Column(name = "estadoHorarioCurso")
    private Boolean estadoHorarioCurso;

    @Column(name = "dias")
    private String dias;

    @Column(name = "horaInicio")
    private String horaInicio;

    @Column(name = "horaFin")
    private String horaFin;

    @JsonIgnore
    @OneToOne(mappedBy = "horarioCurso")
    private Curso curso;
}
