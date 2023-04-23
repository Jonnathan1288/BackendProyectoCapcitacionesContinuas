package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@Entity
@Table(name = "programas")
public class Programas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrograma")
    private Integer idPrograma;

    private String nombrePrograma;
    private String periodoPrograma;
    private LocalDate fechaInicioPrograma;
    private LocalDate fechaFinPrograma;
    private String obervacionPrograma;
    private Boolean estadoProgramaActivo;

    // Relacionado con usuario
    @ManyToOne
    @JoinColumn(name="idUsuario",referencedColumnName ="idUsuario")
    private Usuario usuario;
}
