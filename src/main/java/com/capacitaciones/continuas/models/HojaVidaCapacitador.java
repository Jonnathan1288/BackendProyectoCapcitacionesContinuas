package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "hojavidacapacitadores")
public class HojaVidaCapacitador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHojaVida")
    private Integer idHojaVida;

    private String  experiencialLaboral;
    private String sobreMi;
    private String  experienciaEscolar;
    private String destrezas;
    private String idiomas;


    // Relacion con capacitador
    @OneToOne
    @JoinColumn(name = "idCapacitador", referencedColumnName = "idCapacitador")
    private Capacitador capacitador;

}
