package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "detallefichamatriculas")
public class DetalleFichaMatricula { // esta entidad esta en vigencia.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleFichaMatricula")
    private Integer idDetalleFichaMatricula;

    @Column(name = "preguntaDetalle")
    private String preguntaDetalle;

    // Se relaciona con la matricula
    //viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="idFichaMatricula",referencedColumnName ="idFichaMatricula")
    private FichaMatricula fichaMatricula;
}
