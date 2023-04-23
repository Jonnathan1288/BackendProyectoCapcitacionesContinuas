package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.PartipantesMatriculados;
import com.capacitaciones.continuas.models.Persona;
import com.capacitaciones.continuas.services.ParticipantesMatriculadosService;
import com.capacitaciones.continuas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona/listar")
    public ResponseEntity<List<Persona>> obtenerLista() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/persona/crear")
    public ResponseEntity<Persona> crear(@RequestBody Persona c) {
        return new ResponseEntity<>(personaService.save(c), HttpStatus.CREATED);
    }

}
