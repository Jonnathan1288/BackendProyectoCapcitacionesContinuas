package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.models.FichaMatricula;
import com.capacitaciones.continuas.services.EvaluacionFormativaCurricularService;
import com.capacitaciones.continuas.services.FichaMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class FichaMatriculaController {
    @Autowired
    private FichaMatriculaService fichaMatriculaService;

    @GetMapping("/fichaMatricula/list")
    public ResponseEntity<List<FichaMatricula>> listFichaMatricula(){
        try {
            return new ResponseEntity<>(fichaMatriculaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fichaMatricula/findbyId/{id}")
    public ResponseEntity<?> getFichaMatriculaById(@PathVariable("id") Integer id){
        try {
            FichaMatricula dc = fichaMatriculaService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("fichaMatricula NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/fichaMatricula/save")
    public ResponseEntity<FichaMatricula> saveFichaMatricula(@RequestBody FichaMatricula fichaMatricula){
        try {
            return new ResponseEntity<>(fichaMatriculaService.save(fichaMatricula), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/fichaMatricula/update/{id}")
    public ResponseEntity<FichaMatricula> actualizarFichaMatricula(@PathVariable Integer id, @RequestBody FichaMatricula fichaMatricula) {
        try {
            if (fichaMatriculaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            fichaMatricula.setInscrito(fichaMatricula.getInscrito());

            FichaMatricula newObject = fichaMatriculaService.save(fichaMatricula);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
