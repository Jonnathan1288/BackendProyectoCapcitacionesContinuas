package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "hojavidacapacitadores")
public class HojaVidaCapacitador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoja_vida")
    private Integer idHojaVida;

    @Column(name = "documento", length = 300)
    private String documento;

    @Column(name = "status")
    private Boolean status;

    // Relacion con capacitador
    @OneToOne
    @JoinColumn(name = "id_capacitador", referencedColumnName = "id_capacitador")
    private Capacitador capacitador;

}
