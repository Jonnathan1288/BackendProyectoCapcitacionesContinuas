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


    @GetMapping("/generarSilabo/downloadSilabo/{id}")
    public void downloadSilabo(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        try {
            jasperReportService.generateSilabo(response, id);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarFichaInscripcion/downloadFicha/{id}")
    public void downloadFichaInscripcion(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        try {
            jasperReportService.generateFichaInscripccion(response, id);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarInformeFinal/downloadInforme/{id_curso}")
    public void downloadInformeFinal(HttpServletResponse response, @PathVariable("id_curso") Integer id_curso) throws Exception {
        try {
            jasperReportService.generateInformeFinal(response, id_curso);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarRegistroParticipantes/downloadRegistro/{id_curso}")
    public void downloadRegistroParticipantes(HttpServletResponse response, @PathVariable("id_curso") Integer id_curso) throws Exception {
        try {
            jasperReportService.generateRegistroParticipantes(response, id_curso);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

}
