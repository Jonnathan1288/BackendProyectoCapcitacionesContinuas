package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Matricula;
import com.capacitaciones.continuas.models.MecanismosEvaluacionCurricular;
import com.capacitaciones.continuas.services.MatriculaService;
import com.capacitaciones.continuas.services.MecanismoEvaluacionCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class MecanismoEvaluacionCurricularController {

    @Autowired
    MecanismoEvaluacionCurricularService mecanismoEvaluacionCurricularService;

    @GetMapping("/mecanismoEvaluacionCurricular/listar")
    public ResponseEntity<List<MecanismosEvaluacionCurricular>> obtenerLista() {
        return new ResponseEntity<>(mecanismoEvaluacionCurricularService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/mecanismoEvaluacionCurricular/crear")
    public ResponseEntity<MecanismosEvaluacionCurricular> crear(@RequestBody MecanismosEvaluacionCurricular c) {
        return new ResponseEntity<>(mecanismoEvaluacionCurricularService.save(c), HttpStatus.CREATED);
    }
}
