package com.capacitaciones.continuas.controllers;

import models.ParticipantesAprobados;
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
        try {
            return new ResponseEntity<>(participantesAprobadosService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/participantesAprobados/crear")
    public ResponseEntity<ParticipantesAprobados> crear(@RequestBody ParticipantesAprobados c) {
        try {
        return new ResponseEntity<>(participantesAprobadosService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/participantesAprobados/findbyId/{id}")
    public ResponseEntity<?> getParticipantesAprobadosById(@PathVariable("id") Integer id){
        try {
            ParticipantesAprobados nc = participantesAprobadosService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PARTICIPANTE APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/participantesAprobados/actualizar/{id}")
    public ResponseEntity<ParticipantesAprobados> actualizarParticipantesAprobados(@PathVariable Integer id, @RequestBody ParticipantesAprobados participantesAprobados) {
        try {
            if (participantesAprobadosService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            participantesAprobados.setCodigoSenecyt(participantesAprobados.getCodigoSenecyt());
            return new ResponseEntity<>(participantesAprobadosService.save(participantesAprobados), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
