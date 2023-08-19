package com.capacitaciones.continuas.interfaces;

import javax.persistence.Column;

public interface CoursesFilter {

    @Column(name="idCurso")
    Integer getidCurso();

    @Column(name = "nombreCurso")
    String getnombreCurso();

    @Column(name = "docente")
    String getdocente();

}
