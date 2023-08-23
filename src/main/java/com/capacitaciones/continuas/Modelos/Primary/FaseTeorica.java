package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "fasesTeoricas")
public class FaseTeorica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFaseTeorica")
    private Integer idFaseTeorica;

    @Column(name = "nombreFase")
    private String nombreFase;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name="idInstalacion",referencedColumnName ="idInstalacion")
    private Instalacion instalacion;

    @ManyToOne
    @JoinColumn(name="idRecurso",referencedColumnName ="idRecurso")
    private Recurso recurso;

    @ManyToOne
    @JoinColumn(name="id_disenio_curricular",referencedColumnName ="id_disenio_curricular")
    private DisenioCurricular disenioCurricular;

    // REFERENCIA DE LAS RELACIONES
    /*@JsonIgnore
    @OneToMany(mappedBy = "area")
    private List<Especialidad> Especialidad;*/

}
