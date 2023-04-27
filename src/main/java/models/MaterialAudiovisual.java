package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "materialAudiovisuales")
public class MaterialAudiovisual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaterialAudiovisual")
    private Integer idMaterialAudiovisual;

    @Column(name = "descripcionMaterialAudiovisual")
    private String descripcionMaterialAudiovisual;

    @Column(name = "estadoMaterialAudiovisual")
    private Boolean estadoMaterialAudiovisual;

    @ManyToOne
    @JoinColumn(name="idSilabo",referencedColumnName ="idSilabo")
    private Silabo silabo;


}
