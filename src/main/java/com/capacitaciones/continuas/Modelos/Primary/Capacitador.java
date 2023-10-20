package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "capacitadores")
public class Capacitador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_capacitador")
    private Integer idCapacitador;

    @Column(name = "titulo_capacitador", length = 300)
    private String tituloCapacitador;

    @Column(name = "estado_activo_capacitador")
    private Boolean estadoActivoCapacitador;

    @Column(name = "tipo_abreviatura_titulo", length = 100)
    private String tipoAbreviaturaTitulo;

    // Referencia con su hoja de vida
    @JsonIgnore
    @OneToOne(mappedBy = "capacitador")
    private HojaVidaCapacitador hojaVidaCapacitador;

    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;

}
