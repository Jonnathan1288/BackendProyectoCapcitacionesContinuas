package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.HojaVidaCapacitador;
import com.capacitaciones.continuas.services.HojaVidaCapacitadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class HojaVidaCapacitadorController {

    @Autowired
    HojaVidaCapacitadorService hojaVidaCapacitadorService;

    @GetMapping("/hojaVidaCapcitador/listar")
    public ResponseEntity<List<HojaVidaCapacitador>> obtenerLista() {
        return new ResponseEntity<>(hojaVidaCapacitadorService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/hojaVidaCapcitador/crear")
    public ResponseEntity<HojaVidaCapacitador> crear(@RequestBody HojaVidaCapacitador c) {
        return new ResponseEntity<>(hojaVidaCapacitadorService.save(c), HttpStatus.CREATED);
    }
}
