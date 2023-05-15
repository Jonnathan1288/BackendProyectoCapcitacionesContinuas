package com.capacitaciones.continuas.services;

import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


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
    public void generateFichaInscripccion(HttpServletResponse response, Integer idCurso, Integer idUsuario) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/FormularioInscripción.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cenep.png");
            params.put("ista", "ista.jpeg");
            params.put("idCurso", idCurso);
            params.put("idUsuario", idUsuario);

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
    public void generateRegisterFotografico(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/RegistroFotografico.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cenep.png");
            params.put("ista", "ista.jpeg");
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=RegistroFotografico.pdf");

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
    public void generateRegisterAsistenciaEvaluacion(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/RegistroAsistenciEvaluacion.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cenep.png");
            params.put("ista", "ista.jpeg");
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=RegistroAsistenciaEvaluacion.pdf");

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

    @Override
    public void generateRegistroParticipantes(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ReporteRegistroParticipantes.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cene.png");
            params.put("ista", "ista.jpeg");
            params.put("idCursoPrincipal", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=registroParticipantes.pdf");

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
    public void generateHojaVida(HttpServletResponse response, Integer idCapacitador) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/reportHojadeVida.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cene.png");
            params.put("ista", "ista.jpeg");
            params.put("idCapacitador", idCapacitador);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=HojadeVida.pdf");

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
    public void generateEntregaCertificadoCursoCapacitacion(HttpServletResponse response, Integer idcurso) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/registroentregaCertificado.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cene.png");
            params.put("ista", "ista.jpeg");
            params.put("idCurso", idcurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=EntregaCertificadoCurso.pdf");

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
    public void generatepRrogramacionMensual(HttpServletResponse response, Integer mes, Integer anio) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ProgramacionMensual.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cenep.png");
            params.put("ista", "ista.jpeg");
            params.put("mes", mes);
            params.put("year", anio);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=ProgramacionMensual.pdf");

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
    public void generateCodigoAsignarCenecyt(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ListaCodigosAsiganar.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", "cene.png");
            params.put("ista", "ista.jpeg");
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=codigoAsignarSnecyt.pdf");

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
    public void generateCertificadoEstudiante(HttpServletResponse response, Integer idCurso, String identificasion) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/Certificado.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("g", "g.png");
            params.put("is", "is.jpg");
            params.put("l", "l.png");
            params.put("r", "r.png");
            params.put("s", "s.png");
            params.put("ti", "ti.png");
            params.put("ts", "ts.png");
            params.put("idCurso", idCurso);
            params.put("ci", identificasion);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=" + "Certificado"+identificasion + ".pdf");
            //response.setHeader("Content-Disposition", "attachment; filename=Certificado.pdf");

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
    public void generateDisenioC(HttpServletResponse response, Integer idDisenioCurricular) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/DiseñoC.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("senescyt", "senescyt.png");
            params.put("idDisenioCPrimary", idDisenioCurricular);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=DiseñoCurricularReport.pdf");

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
    public void generateFichaEvaluacionFinal(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/fichaevaluacionCurso.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("ista", "is.jpg");
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=FichaEvaluacionFinal.pdf");

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
