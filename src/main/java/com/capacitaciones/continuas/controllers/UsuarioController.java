package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Silabo;
import com.capacitaciones.continuas.models.Usuario;
import com.capacitaciones.continuas.services.SilaboService;
import com.capacitaciones.continuas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario/listar")
    public ResponseEntity<List<Usuario>> obtenerLista() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/usuario/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario c) {
        return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
    }
}
