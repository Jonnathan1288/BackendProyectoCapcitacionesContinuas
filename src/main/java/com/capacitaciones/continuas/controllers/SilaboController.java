package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Rol;
import com.capacitaciones.continuas.models.Silabo;
import com.capacitaciones.continuas.services.RolService;
import com.capacitaciones.continuas.services.SilaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class SilaboController {

    @Autowired
    SilaboService silaboService;

    @GetMapping("/silabo/listar")
    public ResponseEntity<List<Silabo>> obtenerLista() {
        return new ResponseEntity<>(silaboService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/silabo/crear")
    public ResponseEntity<Silabo> crear(@RequestBody Silabo c) {
        return new ResponseEntity<>(silaboService.save(c), HttpStatus.CREATED);
    }
}
