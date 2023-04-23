package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.RegistroFotograficoCurso;
import com.capacitaciones.continuas.models.ResultadoAprendizajeSilabo;
import com.capacitaciones.continuas.services.RegistroFotograficoCursoService;
import com.capacitaciones.continuas.services.ResultadoAprendizajeSilaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class ResultadoAprendizajeSilaboController {

    @Autowired
    ResultadoAprendizajeSilaboService resultadoAprendizajeSilaboService;

    @GetMapping("/resultadoAprendizajeSilabo/listar")
    public ResponseEntity<List<ResultadoAprendizajeSilabo>> obtenerLista() {
        return new ResponseEntity<>(resultadoAprendizajeSilaboService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/resultadoAprendizajeSilabo/crear")
    public ResponseEntity<ResultadoAprendizajeSilabo> crear(@RequestBody ResultadoAprendizajeSilabo c) {
        return new ResponseEntity<>(resultadoAprendizajeSilaboService.save(c), HttpStatus.CREATED);
    }
}
