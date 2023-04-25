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
}
