package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.DetalleEvaluacionFinal;
import com.capacitaciones.continuas.models.DisenioCurricular;
import com.capacitaciones.continuas.services.DetalleEvaluacionFinalService;
import com.capacitaciones.continuas.services.DisenioCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class DisenioCurricularController {
    @Autowired
    private DisenioCurricularService disenioCurricularService;

    @GetMapping("/disenioCurricular/list")
    public ResponseEntity<List<DisenioCurricular>> listDisenioCurricular(){
        try {
            return new ResponseEntity<>(disenioCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/disenioCurricular/save")
    public ResponseEntity<DisenioCurricular> saveDisenioCurricular(@RequestBody DisenioCurricular disenioCurricular){
        try {
            return new ResponseEntity<>(disenioCurricularService.save(disenioCurricular), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
