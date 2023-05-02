package com.capacitaciones.continuas.Modelos.Secondary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class vusuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idVusuario")
    private Integer idVusuario;

    private String nombreprincipam;
}
