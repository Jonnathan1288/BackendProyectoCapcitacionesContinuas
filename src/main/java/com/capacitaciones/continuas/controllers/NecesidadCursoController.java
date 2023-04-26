package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.NecesidadCurso;
import com.capacitaciones.continuas.services.NecesidadCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class NecesidadCursoController {

    @Autowired
    NecesidadCursoService necesidadCursoService;

    @GetMapping("/necesidadCurso/listar")
    public ResponseEntity<List<NecesidadCurso>> obtenerNecesidadCurso() {
        try {
            return new ResponseEntity<>(necesidadCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/necesidadCurso/findbyId/{id}")
    public ResponseEntity<?> getNecesidadCursoById(@PathVariable("id") Integer id){
        try {
            NecesidadCurso necesidadCurso = necesidadCursoService.findById(id);
            if(necesidadCurso != null){
                return new ResponseEntity<>(necesidadCurso, HttpStatus.OK);
            }
            return new ResponseEntity<>("NECESIDAD CURSO NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/necesidadCurso/crear")
    public ResponseEntity<NecesidadCurso> crearNecesidadCurso(@RequestBody NecesidadCurso c) {
        try {
            return new ResponseEntity<>(necesidadCursoService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
