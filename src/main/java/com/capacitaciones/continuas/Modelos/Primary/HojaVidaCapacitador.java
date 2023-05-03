package com.capacitaciones.continuas.Modelos.Primary;

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
    @Column(name = "id_hoja_vida")
    private Integer idHojaVida;

    @Column(name = "experiencial_laboral")
    private String  experiencialLaboral;

    @Column(name = "sobre_mi")
    private String sobreMi;

    @Column(name = "experiencia_escolar")
    private String  experienciaEscolar;

    @Column(name = "destrezas")
    private String destrezas;

    @Column(name = "idiomas")
    private String idiomas;

    @Column(name = "estadoAprobacion")
    private String estadoAprobacion;

    @Column(name = "documento", columnDefinition = "LONGBLOB")
    private byte[] documento;

    // Relacion con capacitador
    @OneToOne
    @JoinColumn(name = "id_capacitador", referencedColumnName = "id_capacitador")
    private Capacitador capacitador;

}
