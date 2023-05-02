package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Secondary.vusuario;
import com.capacitaciones.continuas.services.VusarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class VusuarioService {

    @Autowired
    VusarioService vusarioService;

    @GetMapping("/vusario/listar")
    public ResponseEntity<List<vusuario>> obtenerLista() {
        try {
            return new ResponseEntity<>(vusarioService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vusario/crear")
    public ResponseEntity<vusuario> crear(@RequestBody vusuario c) {
        try {
            return new ResponseEntity<>(vusarioService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
