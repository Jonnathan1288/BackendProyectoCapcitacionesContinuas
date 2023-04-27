package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "materialConvencionales")
public class MaterialConvencional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaterialConvencional")
    private Integer idMaterialConvencional;

    @Column(name = "descripcionMaterialConvencional")
    private String descripcionMaterialConvencional;

    @Column(name = "estadoMaterialConvencional")
    private Boolean estadoMaterialConvencional;

    @ManyToOne
    @JoinColumn(name="idSilabo",referencedColumnName ="idSilabo")
    private Silabo silabo;


}
