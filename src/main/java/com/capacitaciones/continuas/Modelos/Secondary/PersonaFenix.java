package com.capacitaciones.continuas.Modelos.Secondary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "edcpersonasfenix")
public class PersonaFenix implements Serializable {

    @Id
    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular")
    private String celular;

    @Column(name = "genero")
    private String genero;

    @Column(name = "etnia")
    private String etnia;
}
