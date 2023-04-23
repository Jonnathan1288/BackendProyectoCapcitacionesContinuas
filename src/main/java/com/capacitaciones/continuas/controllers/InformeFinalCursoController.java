package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.models.InformeFinalCurso;
import com.capacitaciones.continuas.services.InformeFinalCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class InformeFinalCursoController {

    @Autowired
    InformeFinalCursoService informeFinalCursoService;

    @GetMapping("/informeFinalCurso/listar")
    public ResponseEntity<List<InformeFinalCurso>> obtenerLista() {
        return new ResponseEntity<>(informeFinalCursoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/informeFinalCurso/crear")
    public ResponseEntity<InformeFinalCurso> crear(@RequestBody InformeFinalCurso c) {
        return new ResponseEntity<>(informeFinalCursoService.save(c), HttpStatus.CREATED);
    }
}
