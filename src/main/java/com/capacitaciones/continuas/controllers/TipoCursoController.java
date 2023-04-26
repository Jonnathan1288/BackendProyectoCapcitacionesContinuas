package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Area;
import com.capacitaciones.continuas.models.TipoCurso;
import com.capacitaciones.continuas.services.AreaService;
import com.capacitaciones.continuas.services.TipoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class TipoCursoController {
    @Autowired
    private TipoCursoService tipoCursoService;

    @GetMapping("/tipoCurso/list")
    public ResponseEntity<List<TipoCurso>> listTipoCurso(){
        try {
            return new ResponseEntity<>(tipoCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tipoCurso/findbyId/{id}")
    public ResponseEntity<?> getTipoCursoById(@PathVariable("id") Integer id){
        try {
            TipoCurso tc = tipoCursoService.findById(id);
            if(tc != null){
                return new ResponseEntity<>(tc, HttpStatus.OK);
            }
            return new ResponseEntity<>("TPO CURSO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tipoCurso/save")
    public ResponseEntity<TipoCurso> saveTipoCurso(@RequestBody TipoCurso tc){
        try {
            return new ResponseEntity<>(tipoCursoService.save(tc), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
