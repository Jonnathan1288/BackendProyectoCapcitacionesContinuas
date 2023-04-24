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
