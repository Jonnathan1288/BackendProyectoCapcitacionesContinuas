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

    private String temaContenido;
    private Integer diaContenido;
    private Integer horasClaseContenido;
    private String actividadesDocencia;
    private Integer horasPracticas;
    private String actividadesPracticas;
    private Integer horasAutonomas;
    private String actividadesAutonomas;
    private String observaciones;
    private Boolean estadoContenido;

    // Se relaciona con Silabo

    @ManyToOne
    @JoinColumn(name="idResultadoAprendizajeSilabo",referencedColumnName ="idResultadoAprendizajeSilabo")
    private ResultadoAprendizajeSilabo resultadoAprendizajeSilabo;
}
