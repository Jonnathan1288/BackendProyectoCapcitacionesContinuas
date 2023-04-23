package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.ResultadoAprendizajeSilabo;
import com.capacitaciones.continuas.models.Rol;
import com.capacitaciones.continuas.services.ResultadoAprendizajeSilaboService;
import com.capacitaciones.continuas.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    RolService rolService;

    @GetMapping("/rol/listar")
    public ResponseEntity<List<Rol>> obtenerLista() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/rol/crear")
    public ResponseEntity<Rol> crear(@RequestBody Rol c) {
        return new ResponseEntity<>(rolService.save(c), HttpStatus.CREATED);
    }
}
