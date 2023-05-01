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

    @GetMapping("/generarRegisroFotografico/downloadRegistroFotografico/{idCurso}")
    public void downloadRegistroFotografico(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso) throws Exception {
        try {
            jasperReportService.generateRegisterFotografico(response, idCurso);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarRegistroAsistenciaEvaluacion/download/{idCurso}")
    public void downloadRegistroAsistenciaEvaluacion(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso) throws Exception {
        try {
            jasperReportService.generateRegisterAsistenciaEvaluacion(response, idCurso);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

}
