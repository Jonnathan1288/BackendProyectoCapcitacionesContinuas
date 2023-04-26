package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.ParticipantesAprobados;
import com.capacitaciones.continuas.models.PartipantesMatriculados;
import com.capacitaciones.continuas.services.ParticipantesAprobadosService;
import com.capacitaciones.continuas.services.ParticipantesMatriculadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class ParticipanteMatriculadosController {

    @Autowired
    ParticipantesMatriculadosService participantesMatriculadosService;

    @GetMapping("/participantesMatriculados/listar")
    public ResponseEntity<List<PartipantesMatriculados>> obtenerLista() {
        try {
            return new ResponseEntity<>(participantesMatriculadosService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/participantesMatriculados/crear")
    public ResponseEntity<PartipantesMatriculados> crear(@RequestBody PartipantesMatriculados c) {
        try {
            return new ResponseEntity<>(participantesMatriculadosService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
