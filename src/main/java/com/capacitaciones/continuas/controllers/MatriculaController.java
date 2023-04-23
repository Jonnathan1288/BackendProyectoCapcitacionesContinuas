package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Matricula;
import com.capacitaciones.continuas.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @GetMapping("/matricula/listar")
    public ResponseEntity<List<Matricula>> obtenerLista() {
        return new ResponseEntity<>(matriculaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/matricula/crear")
    public ResponseEntity<Matricula> crear(@RequestBody Matricula c) {
        return new ResponseEntity<>(matriculaService.save(c), HttpStatus.CREATED);
    }
}
