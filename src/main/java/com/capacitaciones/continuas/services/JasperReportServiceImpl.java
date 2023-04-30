package com.capacitaciones.continuas.services;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
@Service
public class JasperReportServiceImpl implements JasperReportService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void generateReport(HttpServletResponse response, Integer ids) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/js.jasper");

            Map<String, Object> params = new HashMap<>();
            params.put("idSilabo", ids);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

@Override
    public void generateReportInformeNecesidadCurso(HttpServletResponse response, Integer idCursoNecesidadC) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/informeNecesidad.jasper");

            Map<String, Object> params = new HashMap<>();
            params.put("ista", "ista.jpeg");
            params.put("cene", "cene.png");
            params.put("idCurso", idCursoNecesidadC);


            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }
    
    @Override
    public void generateSilabo(HttpServletResponse response, Integer idSilabo) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/repsilabo.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cene.png");
            params.put("ista", "ista.jpeg");
            params.put("idSilaboPrimary", idSilabo);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=silaboReport.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generateFichaInscripccion(HttpServletResponse response, Integer id) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/FormularioInscripción.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cene.png");
            params.put("ista", "ista.jpeg");
            params.put("idMatricula", id);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=formularioIncripcion.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generateInformeFinal(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ReporteFinalCurso.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cene.png");
            params.put("ista", "ista.jpeg");
            params.put("id_Curso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=ReporteFinalCurso.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }
}
