package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.DisenioCurricular;
import com.capacitaciones.continuas.models.EntornoAprendizajeCurricular;
import com.capacitaciones.continuas.services.DisenioCurricularService;
import com.capacitaciones.continuas.services.EntornoAprendizajeCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EntornoAprendizajeController {
    @Autowired
    private EntornoAprendizajeCurricularService entornoAprendizajeCurricularService;

    @GetMapping("/entornoAprendizajeCurricular/list")
    public ResponseEntity<List<EntornoAprendizajeCurricular>> listDisenioCurricular(){
        try {
            return new ResponseEntity<>(entornoAprendizajeCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/entornoAprendizajeCurricular/save")
    public ResponseEntity<EntornoAprendizajeCurricular> saveDisenioCurricular(@RequestBody EntornoAprendizajeCurricular entornoAprendizajeCurricular){
        try {
            return new ResponseEntity<>(entornoAprendizajeCurricularService.save(entornoAprendizajeCurricular), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
