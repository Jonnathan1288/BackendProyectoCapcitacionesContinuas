package com.capacitaciones.continuas.interfaces;
import java.time.LocalDate;

public interface NotasReduce {
    Integer getidNota();
    Integer getinforme1();
    Integer getinforme2();
    Integer getinforme3();
    Integer getexamenFinal();
    String  getobservacion();
    String  getnombres();
    String getidentificacion();
    Integer getidCurso();
    String getnombreCurso();
    LocalDate getfechaInicioCurso();
    LocalDate getfechaFinalizacionCurso();
    Integer getidParticipanteMatriculado();
}