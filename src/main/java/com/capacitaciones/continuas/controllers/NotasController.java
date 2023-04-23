package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.NecesidadCurso;
import com.capacitaciones.continuas.models.Notas;
import com.capacitaciones.continuas.services.NecesidadCursoService;
import com.capacitaciones.continuas.services.NotasSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class NotasController {

    @Autowired
    NotasSevice notasSevice;

    @GetMapping("/notas/listar")
    public ResponseEntity<List<Notas>> obtenerLista() {
        return new ResponseEntity<>(notasSevice.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/notas/crear")
    public ResponseEntity<Notas> crear(@RequestBody Notas c) {
        return new ResponseEntity<>(notasSevice.save(c), HttpStatus.CREATED);
    }
}
