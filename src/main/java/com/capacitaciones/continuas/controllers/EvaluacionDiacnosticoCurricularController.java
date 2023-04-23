package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Especialidad;
import com.capacitaciones.continuas.models.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.services.EspecialidadService;
import com.capacitaciones.continuas.services.EvaluacionDiacnosticaCurricularService;
import com.capacitaciones.continuas.services.EvaluacionFormativaCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EvaluacionDiacnosticoCurricularController {
    @Autowired
    private EvaluacionDiacnosticaCurricularService evaluacionDiacnosticaCurricularService;

    @GetMapping("/evaluacionDiacnosticaCurricular/list")
    public ResponseEntity<List<EvaluacionDiagnosticaCurricular>> listEvaluacionDiacnosticoCurricular(){
        try {
            return new ResponseEntity<>(evaluacionDiacnosticaCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/evaluacionDiacnosticaCurricular/save")
    public ResponseEntity<EvaluacionDiagnosticaCurricular> saveEvaluacionDiacnosticoCurricular(@RequestBody EvaluacionDiagnosticaCurricular ev){
        try {
            return new ResponseEntity<>(evaluacionDiacnosticaCurricularService.save(ev), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
