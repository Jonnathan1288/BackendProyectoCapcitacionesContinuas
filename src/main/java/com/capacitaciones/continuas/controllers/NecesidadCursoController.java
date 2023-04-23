package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.MecanismosEvaluacionCurricular;
import com.capacitaciones.continuas.models.NecesidadCurso;
import com.capacitaciones.continuas.services.MecanismoEvaluacionCurricularService;
import com.capacitaciones.continuas.services.NecesidadCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class NecesidadCursoController {

    @Autowired
    NecesidadCursoService necesidadCursoService;

    @GetMapping("/necesidadCurso/listar")
    public ResponseEntity<List<NecesidadCurso>> obtenerLista() {
        return new ResponseEntity<>(necesidadCursoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/necesidadCurso/crear")
    public ResponseEntity<NecesidadCurso> crear(@RequestBody NecesidadCurso c) {
        return new ResponseEntity<>(necesidadCursoService.save(c), HttpStatus.CREATED);
    }
}
