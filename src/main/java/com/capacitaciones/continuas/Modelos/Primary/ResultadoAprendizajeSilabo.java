package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "resultado_aprendizaje_silabo")
public class ResultadoAprendizajeSilabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultado_aprendizaje_silabo")
    private Integer idResultadoAprendizajeSilabo;

    @Column(name = "tema_unidad_silabo")
    private String temaUnidadSilabo;

    @Column(name = "descripcion_unidad_silabo")
    private String descripcionUnidadSilabo;

    @Column(name = "elementos_competencia_silabo")
    private String elementosCompetenciaSilabo;

    @Column(name = "activades_resultado_aprendizaje")
    private String activadesResultadoAprendizaje;

    @Column(name = "forma_evidenciar")
    private String formaEvidenciar;

    @Column(name = "estado_unidad_activo")
    private Boolean estadoUnidadActivo;

    // RELACIONAR CON SILABO
    @ManyToOne
    @JoinColumn(name = "id_silabo", referencedColumnName = "id_silabo")
    private Silabo silabo;
}

