package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "recursos")
public class Recurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRecurso")
    private Integer idRecurso;

    @Column(name = "nombreRecurso")
    private String nombreRecurso;

    @Column(name = "estado")
    private Boolean estado;

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "recurso")
    private List<FaseTeorica> faseTeoricaList;

    @JsonIgnore
    @OneToMany(mappedBy = "recurso")
    private List<FasePractica> fasePracticaList;

}
