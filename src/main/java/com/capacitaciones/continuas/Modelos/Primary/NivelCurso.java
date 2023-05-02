package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "nivelesCursos")
public class NivelCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNivelCurso")
    private Integer idNivelCurso;

    @Column(name = "estadoNivelCurso")
    private Boolean estadoNivelCurso;

    @Column(name = "nombreNivelCurso")
    private String nombreNivelCurso;



}
