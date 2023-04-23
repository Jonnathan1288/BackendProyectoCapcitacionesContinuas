package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Programas;
import com.capacitaciones.continuas.models.RegistroFotograficoCurso;
import com.capacitaciones.continuas.services.ProgramaService;
import com.capacitaciones.continuas.services.RegistroFotograficoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class RegistroFotograficoCursoController {

    @Autowired
    RegistroFotograficoCursoService registroFotograficoCursoService;

    @GetMapping("/registroFotograficoCurso/listar")
    public ResponseEntity<List<RegistroFotograficoCurso>> obtenerLista() {
        return new ResponseEntity<>(registroFotograficoCursoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/registroFotograficoCurso/crear")
    public ResponseEntity<RegistroFotograficoCurso> crear(@RequestBody RegistroFotograficoCurso c) {
        return new ResponseEntity<>(registroFotograficoCursoService.save(c), HttpStatus.CREATED);
    }
}
