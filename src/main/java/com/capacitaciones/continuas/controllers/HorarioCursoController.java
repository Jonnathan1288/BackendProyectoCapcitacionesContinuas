package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.HorarioCurso;
import com.capacitaciones.continuas.services.HorarioCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class HorarioCursoController {

    @Autowired
    HorarioCursoService horarioCursoService;

    @GetMapping("/horarioCurso/listar")
    public ResponseEntity<List<HorarioCurso>> obtenerLista() {
        return new ResponseEntity<>(horarioCursoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/horarioCurso/crear")
    public ResponseEntity<HorarioCurso> crear(@RequestBody HorarioCurso c) {
        return new ResponseEntity<>(horarioCursoService.save(c), HttpStatus.CREATED);
    }
}
