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

    @Column(name = "documento", columnDefinition = "LONGBLOB")
    private byte[] documento;

    @Column(name = "status")
    private Boolean status;

    // Relacion con capacitador
    @OneToOne
    @JoinColumn(name = "id_capacitador", referencedColumnName = "id_capacitador")
    private Capacitador capacitador;

}
