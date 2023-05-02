package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "programas")
public class Programas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa")
    private Integer idPrograma;

    @Column(name = "nombre_programa")
    private String nombrePrograma;

    @Column(name = "descripcion_programa")
    private String descripcionPrograma;

    @Column(name = "estado_programa_activo")
    private Boolean estadoProgramaActivo;

    // Relación de uno a uno
    @OneToOne
    @JoinColumn(name = "id_periodo_programa", referencedColumnName = "id_periodo_programa")
    private PeriodoPrograma periodoPrograma;
}

