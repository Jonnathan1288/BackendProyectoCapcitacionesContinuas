package com.capacitaciones.continuas.controllers;

import models.ListaNecesidadCurso;
import com.capacitaciones.continuas.services.ListaNecesidadCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ListaNecesidadCursoController {
    @Autowired
    private ListaNecesidadCursoService listaNecesidadCursoService;

    @GetMapping("/listaNecesidadCurso/list")
    public ResponseEntity<List<ListaNecesidadCurso>> listListaNecesidadCurso(){
        try {
            return new ResponseEntity<>(listaNecesidadCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listaNecesidadCurso/save")
    public ResponseEntity<ListaNecesidadCurso> saveListaNecesidadCurso(@RequestBody ListaNecesidadCurso ln){
        try {
            return new ResponseEntity<>(listaNecesidadCursoService.save(ln), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listaNecesidadCurso/findbyId/{id}")
    public ResponseEntity<?> getListaNecesidadCursoById(@PathVariable("id") Integer id){
        try {
            ListaNecesidadCurso materialConvencional = listaNecesidadCursoService.findById(id);
            if(materialConvencional != null){
                return new ResponseEntity<>(materialConvencional, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/listaNecesidadCurso/actualizar/{id}")
    public ResponseEntity<ListaNecesidadCurso> actualizarListaNecesidadCurso(@PathVariable Integer id, @RequestBody ListaNecesidadCurso listaNecesidadCurso) {
        try {
            if (listaNecesidadCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            listaNecesidadCurso.setDetalleNececidadCurso(listaNecesidadCurso.getDetalleNececidadCurso());
            listaNecesidadCurso.setEstadoDetalleNecesidad(listaNecesidadCurso.getEstadoDetalleNecesidad());
            return new ResponseEntity<>(listaNecesidadCursoService.save(listaNecesidadCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
