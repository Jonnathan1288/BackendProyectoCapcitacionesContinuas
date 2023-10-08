package com.capacitaciones.continuas.payload;

import javax.persistence.Column;
import java.time.LocalDate;

public interface PayloadCurso {
    @Column(name="idCurso")
    Integer getidCurso();

    @Column(name="nombreCurso")
    String getnombreCurso();
    @Column(name="nombre")
    String getnombre();

    @Column(name="duracionCurso")
    Integer getduracionCurso();

    @Column(name="horaInicio")
    String gethoraInicio();

    @Column(name="horaFin")
    String gethoraFin();
    @Column(name="dias")
    String getdias();
    @Column(name="fechaInicioCurso")
    LocalDate getfechaInicioCurso();

    @Column(name="fechaFinalizacionCurso")
    LocalDate getfechaFinalizacionCurso();

    @Column(name="numeroCuposCurso")
    String getnumeroCuposCurso();

    @Column(name="nombreNivelCurso")
    String getnombreNivelCurso();

    @Column(name="nombreTipoCurso")
    String getnombreTipoCurso();

    @Column(name="nombreModalidadCurso")
    String getnombreModalidadCurso();

    @Column(name="nombreEspecialidad")
    String getnombreEspecialidad();
}
