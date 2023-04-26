package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.DetalleFichaMatricula;
import com.capacitaciones.continuas.models.PeriodoPrograma;
import com.capacitaciones.continuas.services.DetalleFichaService;
import com.capacitaciones.continuas.services.PeriodoProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class PeriodoProgramaController {
    @Autowired
    private PeriodoProgramaService periodoProgramaService;

    @GetMapping("/periodoPrograma/list")
    public ResponseEntity<List<PeriodoPrograma>> listperiodoPrograma(){
        try {
            return new ResponseEntity<>(periodoProgramaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/periodoPrograma/findbyId/{id}")
    public ResponseEntity<?> getperiodoProgramaById(@PathVariable("id") Integer id){
        try {
            PeriodoPrograma pp = periodoProgramaService.findById(id);
            if(pp != null){
                return new ResponseEntity<>(pp, HttpStatus.OK);
            }
            return new ResponseEntity<>("PERIODO PROGRAMA NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/periodoPrograma/save")
    public ResponseEntity<PeriodoPrograma> saveperiodoPrograma(@RequestBody PeriodoPrograma pp){
        try {
            return new ResponseEntity<>(periodoProgramaService.save(pp), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
