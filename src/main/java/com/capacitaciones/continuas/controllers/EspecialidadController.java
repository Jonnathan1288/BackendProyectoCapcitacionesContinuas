package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.EntornoAprendizajeCurricular;
import com.capacitaciones.continuas.models.Especialidad;
import com.capacitaciones.continuas.services.EntornoAprendizajeCurricularService;
import com.capacitaciones.continuas.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/especialidad/list")
    public ResponseEntity<List<Especialidad>> listEspecialidad(){
        try {
            return new ResponseEntity<>(especialidadService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/especialidad/save")
    public ResponseEntity<Especialidad> saveEspecialidad(@RequestBody Especialidad especialidad){
        try {
            return new ResponseEntity<>(especialidadService.save(especialidad), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
