package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.models.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.services.EvaluacionDiacnosticaCurricularService;
import com.capacitaciones.continuas.services.EvaluacionFinalCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EvaluacionFinalCurricularController {
    @Autowired
    private EvaluacionFinalCurricularService evaluacionFinalCurricularService;

    @GetMapping("/evaluacionFinalCurricular/list")
    public ResponseEntity<List<EvaluacionFinalCurricular>> listEvaluacionFinalCurricular(){
        try {
            return new ResponseEntity<>(evaluacionFinalCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/evaluacionFinalCurricular/save")
    public ResponseEntity<EvaluacionFinalCurricular> saveEvaluacionFinalCurricular(@RequestBody EvaluacionFinalCurricular ef){
        try {
            return new ResponseEntity<>(evaluacionFinalCurricularService.save(ef), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
