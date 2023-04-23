package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Persona;
import com.capacitaciones.continuas.models.Programas;
import com.capacitaciones.continuas.services.PersonaService;
import com.capacitaciones.continuas.services.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class ProgramasController {

    @Autowired
    ProgramaService programaService;

    @GetMapping("/programa/listar")
    public ResponseEntity<List<Programas>> obtenerLista() {
        return new ResponseEntity<>(programaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/programa/crear")
    public ResponseEntity<Programas> crear(@RequestBody Programas c) {
        return new ResponseEntity<>(programaService.save(c), HttpStatus.CREATED);
    }

}
