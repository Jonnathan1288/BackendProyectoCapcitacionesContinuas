package com.capacitaciones.continuas.services;

import javax.servlet.http.HttpServletResponse;

public interface JasperReportService {
    public void generateReport(HttpServletResponse response, Integer ids);
    public void generateReportInformeNecesidadCurso(HttpServletResponse response, Integer idCursoNecesidadC);
}
