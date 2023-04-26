package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "ResultadoAprendizajeSilabo")
public class ResultadoAprendizajeSilabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResultadoAprendizajeSilabo")
    private Integer idResultadoAprendizajeSilabo;

    @Column(name = "temaUnidadSilabo")
    private String temaUnidadSilabo;

    @Column(name = "descripcionUnidadSilabo")
    private String descripcionUnidadSilabo;

    @Column(name = "elementosCompetenciaSilabo")
    private String elementosCompetenciaSilabo;

    @Column(name = "activadesResultadoAprendizaje")
    private String activadesResultadoAprendizaje;

    @Column(name = "formaEvidenciar")
    private String formaEvidenciar;

    @Column(name = "estadoUnidadActivo")
    private Boolean estadoUnidadActivo;

    // RELACIONAR CON SILABO
    @ManyToOne
    @JoinColumn(name="idSilabo",referencedColumnName ="idSilabo")
    private Silabo silabo;


}
