package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.DetalleFichaMatricula;
import com.capacitaciones.continuas.models.NivelCurso;
import com.capacitaciones.continuas.services.DetalleFichaService;
import com.capacitaciones.continuas.services.NivelCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class NivelCursoController {
    @Autowired
    private NivelCursoService nivelCursoService;

    @GetMapping("/nivelCurso/list")
    public ResponseEntity<List<NivelCurso>> listNivelCurso(){
        try {
            return new ResponseEntity<>(nivelCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nivelCurso/findbyId/{id}")
    public ResponseEntity<?> getNivelCursoById(@PathVariable("id") Integer id){
        try {
            NivelCurso nc = nivelCursoService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NIVEL CURSO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/nivelCurso/save")
    public ResponseEntity<NivelCurso> saveNivelCurso(@RequestBody NivelCurso df){
        try {
            return new ResponseEntity<>(nivelCursoService.save(df), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
