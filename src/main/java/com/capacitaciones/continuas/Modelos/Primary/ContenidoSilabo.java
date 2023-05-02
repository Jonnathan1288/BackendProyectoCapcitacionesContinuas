package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "contenido_silabos")
public class ContenidoSilabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenido_silabo")
    private Integer idContenidoSilabo;

    @Column(name = "tema_contenido")
    private String temaContenido;

    @Column(name = "dia_contenido")
    private Integer diaContenido;

    @Column(name = "horas_clase_contenido")
    private Integer horasClaseContenido;

    @Column(name = "actividades_docencia")
    private String actividadesDocencia;

    @Column(name = "horas_practicas")
    private Integer horasPracticas;

    @Column(name = "actividades_practicas")
    private String actividadesPracticas;

    @Column(name = "horas_autonomas")
    private Integer horasAutonomas;

    @Column(name = "actividades_autonomas")
    private String actividadesAutonomas;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estado_contenido")
    private Boolean estadoContenido;

    // Se relaciona con Silabo


    @ManyToOne
    @JoinColumn(name="idSilabo",referencedColumnName ="idSilabo")
    private Silabo silabo;

}
