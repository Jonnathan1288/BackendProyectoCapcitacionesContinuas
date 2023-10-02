package com.capacitaciones.continuas.interfaces;

import java.time.LocalDate;

public interface ListCourseReduce {
    Integer getidCurso();
    String getnameProgram();
    String getusername();
    String getnameCourse();
    LocalDate getfechaInicio();
    LocalDate getfechaFin();
    String getstatusApproved();
    Boolean getstatusFinalized();
    String getemail();
    String urlPhoto();
    String getdocente();
}
