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
@Table(name = "roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre_rol", length = 100, unique = true)
    private String nombreRol;

    @Column(name = "estado_rol_activo")
    private Boolean estadoRolActivo;

    // REFERENCIA DE LAS RELACIONES
   /* @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;*/


}
