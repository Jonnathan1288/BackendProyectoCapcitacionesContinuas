package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.models.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.services.EvaluacionFinalCurricularService;
import com.capacitaciones.continuas.services.EvaluacionFormativaCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EvaluacionFormativaCurricularController {
    @Autowired
    private EvaluacionFormativaCurricularService evaluacionFormativaCurricularService;

    @GetMapping("/evaluacionFormativaCurricular/list")
    public ResponseEntity<List<EvalucionFormativaCurricular>> listEvaluacionFormativaCurricular(){
        try {
            return new ResponseEntity<>(evaluacionFormativaCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/evaluacionFormativaCurricular/save")
    public ResponseEntity<EvalucionFormativaCurricular> saveEvaluacionFormativaCurricular(@RequestBody EvalucionFormativaCurricular efc){
        try {
            return new ResponseEntity<>(evaluacionFormativaCurricularService.save(efc), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
