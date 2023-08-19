package com.capacitaciones.continuas.interfaces;

import javax.persistence.Column;
import java.time.LocalDate;

public interface ListApproved {

    @Column(name="idCurso")
    Integer getidCurso();

    @Column(name = "nombres")
    String getnombres();

    @Column(name = "codigoSenecyt")
    String getcodigoSenecyt();

    @Column(name = "idParticipantesAprobados")
    Integer getidParticipantesAprobados();

    @Column(name = "idParticipanteMatriculado")
    Integer getidParticipanteMatriculado();

    @Column(name = "curso")
    String getcurso();

    @Column(name = "fechaInicio")
    LocalDate getfechaInicio();

    @Column(name = "fechaFin")
    LocalDate getfechaFin();

    @Column(name = "horas")
    Integer gethoras();

    @Column(name = "docente")
    String getdocente();

}
