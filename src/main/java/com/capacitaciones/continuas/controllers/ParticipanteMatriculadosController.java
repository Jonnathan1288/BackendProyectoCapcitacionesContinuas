package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.ParticipantesAprobados;
import com.capacitaciones.continuas.models.PartipantesMatriculados;
import com.capacitaciones.continuas.services.ParticipantesMatriculadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    @GetMapping("/participantesMatriculados/findbyId/{id}")
    public ResponseEntity<?> getPartipantesMatriculadosById(@PathVariable("id") Integer id){
        try {
            PartipantesMatriculados nc = participantesMatriculadosService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PARTICIPANTE APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/participantesMatriculados/actualizar/{id}")
    public ResponseEntity<PartipantesMatriculados> actualizarPartipantesMatriculados(@PathVariable Integer id, @RequestBody PartipantesMatriculados partipantesMatriculados) {
        try {
            if (participantesMatriculadosService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            partipantesMatriculados.setEstadoParticipanteActivo(partipantesMatriculados.getEstadoParticipanteActivo());
            partipantesMatriculados.setEstadoParticipanteAprobacion(partipantesMatriculados.getEstadoParticipanteAprobacion());
            return new ResponseEntity<>(participantesMatriculadosService.save(partipantesMatriculados), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
