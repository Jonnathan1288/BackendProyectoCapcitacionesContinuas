package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "lista_necesidad_cursos")
public class ListaNecesidadCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_necesidad_cursos")
    private Integer idListaNecesidadCursos;

    @Column(name = "detalle_nececidadCurso")
    private String detalleNececidadCurso;

    @Column(name = "estado_detalle_necesidad")
    private Boolean estadoDetalleNecesidad;

    @ManyToOne
    @JoinColumn(name="id_necesidad_curso",referencedColumnName ="id_necesidad_curso")
    private NecesidadCurso necesidadCurso;
    
}
