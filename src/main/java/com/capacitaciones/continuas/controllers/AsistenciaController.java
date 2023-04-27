package com.capacitaciones.continuas.controllers;

import models.Asistencia;
import com.capacitaciones.continuas.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/asistencia/list")
    public ResponseEntity<List<Asistencia>> listAsistencia(){
        try {
            return new ResponseEntity<>(asistenciaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/asistencia/save")
    public ResponseEntity<Asistencia> saveAsistencia(@RequestBody Asistencia asistencia){
        try {
            return new ResponseEntity<>(asistenciaService.save(asistencia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/asistencia/findbyId/{id}")
    public ResponseEntity<?> getAsistenciaById(@PathVariable("id") Integer id){
        try {
            Asistencia asistencia = asistenciaService.findById(id);
            if(asistencia != null){
                return new ResponseEntity<>(asistencia, HttpStatus.OK);
            }
            return new ResponseEntity<>("ASISTENCIA NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/asistencia/actualizar/{id}")
    public ResponseEntity<Asistencia> actualizarAsistencia(@PathVariable Integer id, @RequestBody Asistencia asistencia) {
        try {
            if (asistenciaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            asistencia.setObservacionAsistencia(asistencia.getObservacionAsistencia());
            asistencia.setEstadoAsistencia(asistencia.getEstadoAsistencia());
            Asistencia newObject = asistenciaService.save(asistencia);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
