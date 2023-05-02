package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "informe_final_cursos")
public class InformeFinalCurso { //entidad en vigencia
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informe_final_curso")
    private Integer idInformeFinalCurso;

    @Column(name = "observaciones_informe_final_curso")
    private String observacionesInformeFinalCurso;

    @Column(name = "lugar_informe_final_curso")
    private String lugarInformeFinalCurso;

    @Column(name = "canton_informe_final_curso")
    private String nombreCantonInformeFinalCurso;

    //viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="id_curso",referencedColumnName ="id_curso")
    private Curso curso;
    //Falta la referencai -> detalle final.

}
