package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "contenidosilabos")
public class ContenidoSilabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContenidoSilabo")
    private Integer idContenidoSilabo;

    @Column(name = "temaContenido")
    private String temaContenido;

    @Column(name = "diaContenido")
    private Integer diaContenido;

    @Column(name = "horasClaseContenido")
    private Integer horasClaseContenido;

    @Column(name = "actividadesDocencia")
    private String actividadesDocencia;

    @Column(name = "horasPracticas")
    private Integer horasPracticas;

    @Column(name = "actividadesPracticas")
    private String actividadesPracticas;

    @Column(name = "horasAutonomas")
    private Integer horasAutonomas;

    @Column(name = "actividadesAutonomas")
    private String actividadesAutonomas;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estadoContenido")
    private Boolean estadoContenido;

    // Se relaciona con Silabo

    @ManyToOne
    @JoinColumn(name="idResultadoAprendizajeSilabo",referencedColumnName ="idResultadoAprendizajeSilabo")
    private ResultadoAprendizajeSilabo resultadoAprendizajeSilabo;
}
