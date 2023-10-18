package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "niveles_cursos")
public class NivelCurso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_curso")
    private Integer idNivelCurso;

    @Column(name = "estado_nivel_curso", columnDefinition = "BOOLEAN")
    private Boolean estadoNivelCurso;

    @Column(name = "nombre_nivel_curso", length = 100)
    private String nombreNivelCurso;

}
