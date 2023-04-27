package com.capacitaciones.continuas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurso")
    private Integer idCurso;

    @Column(name = "nombreCurso")
    private String nombreCurso;

    @Column(name = "fotoCurso") //Foto al directorio
    private String fotoCurso;

    @Column(name = "duracionCurso")
    private Integer duracionCurso;

    @Column(name = "observacionCurso")
    private String observacionCurso;

    @Column(name = "estadoCurso")
    private Boolean estadoCurso; // Elimina curso logico

    @Column(name = "estadoAprovacionCurso")
    private String estadoAprovacionCurso; //aprovacion del curso // N = NO NO APROVADO, A = APROVADO, P = PENDIENTE

    @Column(name = "estadoPublicasionCurso")
    private Boolean estadoPublicasionCurso; // para el usuario

    @Column(name = "descripcionCurso")
    private String descripcionCurso;

    @Column(name = "objetivoGeneralesCurso")
    private String objetivoGeneralesCurso;

    @Column(name = "numeroCuposCurso")
    private Integer numeroCuposCurso;

    //Viene la lave de idprograma
    @ManyToOne
    @JoinColumn(name="idPrograma",referencedColumnName ="idPrograma")
    private Programas programas;

    //Viene la lave de idEspecialida
    @ManyToOne
    @JoinColumn(name="idEspecialidad",referencedColumnName ="idEspecialidad")
    private Especialidad especialidad;

    //Viene la lave de idCapacitador
    @ManyToOne
    @JoinColumn(name="idCapacitador",referencedColumnName ="idCapacitador")
    private Capacitador capacitador;


    //Falta todas las referencias..
    @OneToOne
    @JoinColumn(name = "idModalidadCurso", referencedColumnName = "idModalidadCurso")
    private ModalidadCurso modalidadCurso;

    @OneToOne
    @JoinColumn(name = "idTipoCurso", referencedColumnName = "idTipoCurso")
    private TipoCurso tipoCurso;

    @OneToOne
    @JoinColumn(name = "idNivelCurso", referencedColumnName = "idNivelCurso")
    private NivelCurso nivelCurso;

    @OneToOne
    @JoinColumn(name = "idHorarioCurso", referencedColumnName = "idHorarioCurso")
    private HorarioCurso horarioCurso;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<PrerequisitoCurso> prerequisitoCursos;
}
