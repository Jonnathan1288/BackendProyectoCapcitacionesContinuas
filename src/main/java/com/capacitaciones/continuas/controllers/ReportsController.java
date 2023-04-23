package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.services.JasperReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ReportsController {
    @Autowired
    private JasperReportService jasperReportService;

    @GetMapping("/reports/download-report")
    public void downloadReport(HttpServletResponse response) throws Exception {
        try {
            jasperReportService.generateReport(response);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }


}
