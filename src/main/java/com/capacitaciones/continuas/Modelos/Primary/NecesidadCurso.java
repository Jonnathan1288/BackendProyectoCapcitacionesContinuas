package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "necesidadescursos")
public class NecesidadCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_necesidad_curso")
    private Integer idNecesidadCurso;

    @Column(name = "estado_impartir_necesidad_curso")
    private String espacioImpartirNecesidadCurso;

    @Column(name = "resumen_curso")
    private String resumenCurso;

    @Column(name = "poblacion_dirijida")
    private String poblacionDirijida;

//Viene la llave de id curso

    @ManyToOne
    @JoinColumn(name="id_curso",referencedColumnName ="id_curso")
    private Curso curso;
//

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "necesidad_curso")
    private List<ListaNecesidadCurso> listaNecesidadCursos;
}
