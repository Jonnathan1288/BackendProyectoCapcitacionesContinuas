package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.services.JasperReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReportsController {
    @Autowired
    private JasperReportService jasperReportService;

    @GetMapping("/reports/download-report/{id}")
    public void downloadReport(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        try {
            jasperReportService.generateReport(response, id);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/reports/download-report/necesidad-curso/{id}")
    public void downloadReportNecesidadCurso(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        try {
            jasperReportService.generateReportInformeNecesidadCurso(response, id);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }


}
