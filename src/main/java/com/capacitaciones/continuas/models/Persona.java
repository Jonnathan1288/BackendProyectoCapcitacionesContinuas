package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Integer idPersona;

    private String identificacion;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String celular;

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;

    //Relaciones de uno..
    @OneToOne
    @JoinColumn(name = "idTipoGenero", referencedColumnName = "idTipoGenero")
    private TipoGenero tipoGenero;

    @OneToOne
    @JoinColumn(name = "idEtniaPersona", referencedColumnName = "idEtniaPersona")
    private EtniaPersona etniaPersona;

    @OneToOne
    @JoinColumn(name = "idNivelInstruccionPersona", referencedColumnName = "idNivelInstruccionPersona")
    private NivelInstruccionPersona nivelInstruccionPersona;
}
