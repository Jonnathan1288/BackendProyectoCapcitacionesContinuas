package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Integer idRol;

    @Column(name = "nombreRol")
    private String nombreRol;

    @Column(name = "estadoRolActivo")
    private Boolean estadoRolActivo;

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;
}
