package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "fasesPracticas")
public class FasePractica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFasePractica")
    private Integer idFasePractica;

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

}
