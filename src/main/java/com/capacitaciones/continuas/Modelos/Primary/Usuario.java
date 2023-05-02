package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "foto_perfil", columnDefinition = "LONGBLOB")
    private String fotoPerfil;  // igamen para la base de datos

    @Column(name = "estado_usuario_activo")
    private boolean estadoUsuarioActivo;

    // RELACIONES
    @ManyToOne
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="id_rol",referencedColumnName ="id_rol")
    private Rol rol;
}
