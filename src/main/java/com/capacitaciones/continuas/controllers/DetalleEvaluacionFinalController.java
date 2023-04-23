package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Curso;
import com.capacitaciones.continuas.models.DetalleEvaluacionFinal;
import com.capacitaciones.continuas.services.CursoService;
import com.capacitaciones.continuas.services.DetalleEvaluacionFinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class DetalleEvaluacionFinalController {
    @Autowired
    private DetalleEvaluacionFinalService detalleEvaluacionFinalService;

    @GetMapping("/detalleEvaluacionFinal/list")
    public ResponseEntity<List<DetalleEvaluacionFinal>> listDetalleEvaluacionFinal(){
        try {
            return new ResponseEntity<>(detalleEvaluacionFinalService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/detalleEvaluacionFinal/save")
    public ResponseEntity<DetalleEvaluacionFinal> saveCurso(@RequestBody DetalleEvaluacionFinal detalleEvaluacionFinal){
        try {
            return new ResponseEntity<>(detalleEvaluacionFinalService.save(detalleEvaluacionFinal), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
