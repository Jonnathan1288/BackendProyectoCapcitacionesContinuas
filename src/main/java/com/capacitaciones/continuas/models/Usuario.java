package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    private String username;
    private String password;
    private String fotoPerfil;
    private boolean estadoUsuarioActivo;

    // RELACIONES
    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="idRol",referencedColumnName ="idRol")
    private Rol rol;

    //Referencias
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Programas> programas;
}
