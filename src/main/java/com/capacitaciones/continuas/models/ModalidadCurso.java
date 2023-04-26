package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "modalidadesCursos")
public class ModalidadCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModalidadCurso")
    private Integer idModalidadCurso;

    @Column(name = "estadoModalidadCurso")
    private Boolean estadoModalidadCurso;

    @Column(name = "nombreModalidadCurso")
    private String nombreModalidadCurso;

    @JsonIgnore
    @OneToOne(mappedBy = "modalidadCurso")
    private Curso curso;

}
