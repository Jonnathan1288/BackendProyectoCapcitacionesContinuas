package com.capacitaciones.continuas.services;

import javax.servlet.http.HttpServletResponse;

public interface JasperReportService {

    public void generateReportInformeNecesidadCurso(HttpServletResponse response, Integer idCursoNecesidadC);

    public void generateSilabo(HttpServletResponse response, Integer ids);

    public void generateFichaInscripccion(HttpServletResponse response, Integer ids);

    public void generateRegisterFotografico(HttpServletResponse response, Integer idCurso);

    public void generateRegisterAsistenciaEvaluacion(HttpServletResponse response, Integer idCurso);

    public void generateInformeFinal(HttpServletResponse response, Integer idCurso);

    public void generateRegistroParticipantes(HttpServletResponse response, Integer idCurso);

    public void generateHojaVida(HttpServletResponse response, Integer idCapacitador);


}
