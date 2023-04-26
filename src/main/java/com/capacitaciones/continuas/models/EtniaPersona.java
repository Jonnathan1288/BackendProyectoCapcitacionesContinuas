package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "etniasPersonas")
public class EtniaPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtniaPersona")
    private Integer idEtniaPersona;

    @Column(name = "estadoEtniaPersona")
    private Boolean estadoEtniaPersona;

    @Column(name = "nombreEtniaPersona")
    private String nombreEtniaPersona;

    @JsonIgnore
    @OneToOne(mappedBy = "etniaPersona")
    private Persona persona;

}
