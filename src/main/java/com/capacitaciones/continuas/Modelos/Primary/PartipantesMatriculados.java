package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "partipantesmatriculados")
public class PartipantesMatriculados implements Serializable { //estado en  vigencia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participante_matriculado")
    private Integer idParticipanteMatriculado;

    @Column(name = "estado_participante_aprobacion", length = 15)
    private String estadoParticipanteAprobacion;

    @Column(name = "estado_participante_activo", columnDefinition = "BOOLEAN")
    private Boolean estadoParticipanteActivo;

    // se referencia con matricula
    @ManyToOne
    @JoinColumn(name="id_inscrito", referencedColumnName ="id_inscrito")
    private Inscrito inscrito;

    //Flata ref with participantes.. ParticipantesAprobados, Notas, asistencias
}
