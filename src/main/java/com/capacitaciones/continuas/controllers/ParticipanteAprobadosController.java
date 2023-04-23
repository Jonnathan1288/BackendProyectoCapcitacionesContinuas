package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Notas;
import com.capacitaciones.continuas.models.ParticipantesAprobados;
import com.capacitaciones.continuas.services.NotasSevice;
import com.capacitaciones.continuas.services.ParticipantesAprobadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class ParticipanteAprobadosController {

    @Autowired
    ParticipantesAprobadosService participantesAprobadosService;

    @GetMapping("/participantesAprobados/listar")
    public ResponseEntity<List<ParticipantesAprobados>> obtenerLista() {
        return new ResponseEntity<>(participantesAprobadosService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/participantesAprobados/crear")
    public ResponseEntity<ParticipantesAprobados> crear(@RequestBody ParticipantesAprobados c) {
        return new ResponseEntity<>(participantesAprobadosService.save(c), HttpStatus.CREATED);
    }
}
