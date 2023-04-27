package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "periodosProgramas")
public class PeriodoPrograma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPeriodoPrograma")
    private Integer idPeriodoPrograma;

    @Column(name = "estadoPeriodoPrograma")
    private Boolean estadoPeriodoPrograma;

    @Column(name = "fechaInicioPeriodoPrograma")
    private LocalDate fechaInicioPeriodoPrograma;

    @Column(name = "fechaFinPeriodoPrograma")
    private LocalDate fechaFinPeriodoPrograma;

    @Column(name = "nombrePeriodoPrograma")
    private String nombrePeriodoPrograma;

    @JsonIgnore
    @OneToOne(mappedBy = "periodoPrograma")
    private Programas programas;
    
}
