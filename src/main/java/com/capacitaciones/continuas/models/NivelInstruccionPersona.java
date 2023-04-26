package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "nivelInstruccionPersonas")
public class NivelInstruccionPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNivelInstruccionPersona")
    private Integer idNivelInstruccionPersona;

    @Column(name = "estadoNivelInstruccionPersona")
    private Boolean estadoNivelInstruccionPersona;

    @Column(name = "nombreNivelInstruccionPersona")
    private String nombreNivelInstruccionPersona;

    @JsonIgnore
    @OneToOne(mappedBy = "nivelInstruccionPersona")
    private Persona persona;

}
