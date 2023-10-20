package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "identificacion", length = 11, unique = true)
    private String identificacion;

    @Column(name = "nombre1", length = 20)
    private String nombre1;

    @Column(name = "nombre2", length = 20)
    private String nombre2;

    @Column(name = "apellido1", length = 20)
    private String apellido1;

    @Column(name = "apellido2", length = 20)
    private String apellido2;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion", length = 180)
    private String direccion;

    @Column(name = "correo", length = 80)
    private String correo;

    @Column(name = "telefono", length = 11)
    private String telefono;

    @Column(name = "celular", length = 10)
    private String celular;

    @Column(name = "genero", length = 30)
    private String genero;

    @Column(name = "etnia", length = 30)
    private String etnia;

    @Column(name = "nivel_instruccion", length = 30)
    private String nivelInstruccion;

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;
}
