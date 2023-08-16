package com.capacitaciones.continuas.Dtos;

import javax.persistence.Column;
import java.time.LocalDate;

public interface CoursesFilter {

    @Column(name="idCurso")
    Integer getidCurso();

    @Column(name = "nombreCurso")
    String getnombreCurso();

    @Column(name = "docente")
    String getdocente();

}
