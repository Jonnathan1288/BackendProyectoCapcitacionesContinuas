package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Curso;
import com.capacitaciones.continuas.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/curso/list")
    public ResponseEntity<List<Curso>> listCurso(){
        try {
            return new ResponseEntity<>(cursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/curso/save")
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso){
        try {
            return new ResponseEntity<>(cursoService.save(curso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
