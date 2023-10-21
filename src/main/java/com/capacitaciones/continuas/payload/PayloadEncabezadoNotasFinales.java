package com.capacitaciones.continuas.payload;

import javax.persistence.Column;
import java.time.LocalDate;

public interface PayloadEncabezadoNotasFinales {

    @Column(name = "idCurso")
    Integer getIdCurso();

    @Column(name = "nombreCurso")
    String getNombreCurso();

    @Column(name = "horaInicio")
    String getHoraInicio();

    @Column(name = "horaFin")
    String getHoraFin();

    @Column(name = "fechaInicioCurso")
    LocalDate getFechaInicioCurso();

    @Column(name = "nombreModalidadCurso")
    String getNombreModalidadCurso();

    @Column(name = "duracionCurso")
    Integer getDuracionCurso();

    @Column(name = "codigoCurso")
    String getCodigoCurso();

    @Column(name = "fechaFinalizacionCurso")
    LocalDate getFechaFinalizacionCurso();

    @Column(name = "nombreDocente")
    String getNombreDocente();

    @Column(name = "observacionCurso")
    String getObservacionCurso();

    @Column(name = "cantonInformeFinalCurso")
    String getCantonInformeFinalCurso();
}

