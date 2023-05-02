package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(name = "nombre_curso")
    private String nombreCurso;

    @Column(name = "foto_curso",  columnDefinition = "LONGBLOB") //Foto al directorio
    private String fotoCurso;

    @Column(name = "duracion_curso")
    private Integer duracionCurso;

    @Column(name = "observacion_curso")
    private String observacionCurso;

    @Column(name = "estado_curso")
    private Boolean estadoCurso; // Elimina curso logico

    @Column(name = "estado_aprovacion_curso")
    private String estadoAprovacionCurso; //aprovacion del curso // N = NO NO APROVADO, A = APROVADO, P = PENDIENTE

    @Column(name = "estado_publicasion_curso")
    private String estadoPublicasionCurso; // para el usuario V visible, O oculto, I inicio, F finalizo

    @Column(name = "descripcion_curso")
    private String descripcionCurso;

    @Column(name = "objetivo_generales_curso")
    private String objetivoGeneralesCurso;

    @Column(name = "numero_cupos_curso")
    private Integer numeroCuposCurso;

    @Column(name = "fecha_inicioCurso")
    private LocalDate fechaInicioCurso;

    @Column(name = "fecha_finalizacion_curso")
    private LocalDate fechaFinalizacionCurso;

    //Viene la lave de idprograma
    @ManyToOne
    @JoinColumn(name="id_programa",referencedColumnName ="id_programa")
    private Programas programas;

    //Viene la lave de idEspecialida
    @ManyToOne
    @JoinColumn(name="id_especialidad",referencedColumnName ="id_especialidad")
    private Especialidad especialidad;

    //Viene la lave de idCapacitador
    @ManyToOne
    @JoinColumn(name="id_capacitador",referencedColumnName ="id_capacitador")
    private Capacitador capacitador;


    //Falta todas las referencias..
    @ManyToOne
    @JoinColumn(name = "idModalidadCurso", referencedColumnName = "idModalidadCurso")
    private ModalidadCurso modalidadCurso;

    @ManyToOne
    @JoinColumn(name = "idTipoCurso", referencedColumnName = "idTipoCurso")
    private TipoCurso tipoCurso;

    @ManyToOne
    @JoinColumn(name = "idNivelCurso", referencedColumnName = "idNivelCurso")
    private NivelCurso nivelCurso;

    @ManyToOne
    @JoinColumn(name = "idHorarioCurso", referencedColumnName = "idHorarioCurso")
    private HorarioCurso horarioCurso;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<PrerequisitoCurso> prerequisitoCursos;
}
