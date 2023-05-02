package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "nivelescursos")
public class NivelCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_curso")
    private Integer idNivelCurso;

    @Column(name = "estado_nivel_curso")
    private Boolean estadoNivelCurso;

    @Column(name = "nombre_nivel_curso")
    private String nombreNivelCurso;

}
