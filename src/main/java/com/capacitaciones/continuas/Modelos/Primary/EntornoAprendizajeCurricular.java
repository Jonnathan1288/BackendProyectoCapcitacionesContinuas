package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "entornoaprendizajescurriculares")
public class EntornoAprendizajeCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entorno_curricular")
    private Integer idEntornoCurricular;

    @Column(name = "instalaciones")
    private String instalaciones;

    @Column(name = "fase_feorica")
    private String faseTeorica;

    @Column(name = "fase_practica")
    private String fasePractica ;

    // se relaciona con curriculo
    @ManyToOne
    @JoinColumn(name="id_disenio_curricular",referencedColumnName ="id_disenio_curricular")
    private DisenioCurricular disenioCurricular;
}
