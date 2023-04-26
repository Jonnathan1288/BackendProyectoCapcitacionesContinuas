package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Inscrito;
import com.capacitaciones.continuas.services.InscritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class InscritoController {

    @Autowired
    InscritoService matriculaService;

    @GetMapping("/matricula/listar")
    public ResponseEntity<List<Inscrito>> obtenerLista() {
        return new ResponseEntity<>(matriculaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/matricula/crear")
    public ResponseEntity<Inscrito> crear(@RequestBody Inscrito c) {
        return new ResponseEntity<>(matriculaService.save(c), HttpStatus.CREATED);
    }
}
