package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Rol;
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
        try {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/rol/crear")
    public ResponseEntity<Rol> crear(@RequestBody Rol c) {
        try {
        return new ResponseEntity<>(rolService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rol/findbyId/{id}")
    public ResponseEntity<?> getRolById(@PathVariable("id") Integer id){
        try {
            Rol nc = rolService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("ROL NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/rol/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol rol) {
        try {
            if (rolService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            rol.setNombreRol(rol.getNombreRol());
            rol.setEstadoRolActivo(rol.getEstadoRolActivo());
            return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
