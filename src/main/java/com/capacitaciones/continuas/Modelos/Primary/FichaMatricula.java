package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "fichamatriculas")
public class FichaMatricula { // esta entidad esta en vigencia.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha_matricula")
    private Integer idFichaMatricula;

    // Se relaciona con la matricula
    //viene la llave de id curso

    @ManyToOne
    @JoinColumn(name="id_inscrito",referencedColumnName ="id_inscrito")
    private Inscrito inscrito;

    @JsonIgnore
    @OneToMany(mappedBy = "fichaMatricula")
    private List<DetalleFichaMatricula> detalleFichaMatricula;
}
