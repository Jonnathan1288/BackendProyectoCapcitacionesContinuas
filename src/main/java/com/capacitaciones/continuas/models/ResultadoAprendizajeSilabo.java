package com.capacitaciones.continuas.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "ResultadoAprendizajeSilabo")
public class ResultadoAprendizajeSilabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResultadoSilabo")
    private Integer idResultadoSilabo;

    private String temaUnidadSilabo;
    private String descripcionUnidadSilabo;
    private String elementosCompetenciaSilabo;
    private String activadesResultadoAprendizaje;
    private String formaEvidenciar;
    private Boolean estadoUnidadActivo;

    // RELACIONAR CON SILABO
    @ManyToOne
    @JoinColumn(name="idSilabo",referencedColumnName ="idSilabo")
    private Silabo silabo;

}
