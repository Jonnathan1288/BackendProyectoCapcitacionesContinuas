package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Asistencia;
import com.capacitaciones.continuas.models.Capacitador;
import com.capacitaciones.continuas.models.Especialidad;
import com.capacitaciones.continuas.services.AsistenciaService;
import com.capacitaciones.continuas.services.CapacitadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class CapacitadorController {
    @Autowired
    private CapacitadorService capacitadorService;

    @GetMapping("/capacitador/list")
    public ResponseEntity<List<Capacitador>> listCapacitador(){
        try {
            return new ResponseEntity<>(capacitadorService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/capacitador/findbyId/{id}")
    public ResponseEntity<?> getCapacitadorById(@PathVariable("id") Integer id){
        try {
            Capacitador capacitador = capacitadorService.findById(id);
            if(capacitador != null){
                return new ResponseEntity<>(capacitador, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/capacitador/save")
    public ResponseEntity<Capacitador> saveCapacitador(@RequestBody Capacitador capacitador){
        try {
            return new ResponseEntity<>(capacitadorService.save(capacitador), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
