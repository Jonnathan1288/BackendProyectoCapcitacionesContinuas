package com.capacitaciones.continuas.Dtos;

import javax.persistence.Column;
import java.time.LocalDate;

public interface ListApproved {

    @Column(name="idCurso")
    Integer getidCurso();

    @Column(name = "nombres")
    String getnombres();

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
