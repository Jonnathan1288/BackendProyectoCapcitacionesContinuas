package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "material_audiovisuales")
public class MaterialAudiovisual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material_audiovisual")
    private Integer idMaterialAudiovisual;

    @Column(name = "descripcion_material_audiovisual")
    private String descripcionMaterialAudiovisual;

    @Column(name = "estado_aaterial_audiovisual")
    private Boolean estadoMaterialAudiovisual;

    @ManyToOne
    @JoinColumn(name="id_silabo",referencedColumnName ="id_silabo")
    private Silabo silabo;


}
