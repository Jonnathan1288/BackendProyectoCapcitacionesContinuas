package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

}
