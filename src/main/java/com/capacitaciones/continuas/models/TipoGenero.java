package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tiposGeneros")
public class TipoGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoGenero")
    private Integer idTipoGenero;

    @Column(name = "estadoTipoGenero")
    private Boolean estadoTipoGenero;

    @Column(name = "nombreTipoGenero")
    private String nombreTipoGenero;

    @JsonIgnore
    @OneToOne(mappedBy = "tipoGenero")
    private Persona persona;

}
