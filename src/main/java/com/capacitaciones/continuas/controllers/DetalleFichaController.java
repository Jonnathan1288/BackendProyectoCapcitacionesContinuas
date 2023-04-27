package com.capacitaciones.continuas.controllers;

import models.DetalleFichaMatricula;
import com.capacitaciones.continuas.services.DetalleFichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class DetalleFichaController {
    @Autowired
    private DetalleFichaService detalleFichaService;

    @GetMapping("/detalleFichaService/list")
    public ResponseEntity<List<DetalleFichaMatricula>> listDetalleFichaService(){
        try {
            return new ResponseEntity<>(detalleFichaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detalleFichaService/findbyId/{id}")
    public ResponseEntity<?> getDetalleFichaServiceById(@PathVariable("id") Integer id){
        try {
            DetalleFichaMatricula df = detalleFichaService.findById(id);
            if(df != null){
                return new ResponseEntity<>(df, HttpStatus.OK);
            }
            return new ResponseEntity<>("DETALLE FICHA NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/detalleFichaService/save")
    public ResponseEntity<DetalleFichaMatricula> saveDetalleFichaService(@RequestBody DetalleFichaMatricula df){
        try {
            return new ResponseEntity<>(detalleFichaService.save(df), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/detalleFicha/update/{id}")
    public ResponseEntity<DetalleFichaMatricula> actualizarDetalleFichaMatricula(@PathVariable Integer id, @RequestBody DetalleFichaMatricula dfm) {
        try {
            if (detalleFichaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            dfm.setPreguntaDetalle(dfm.getPreguntaDetalle());
            dfm.setFichaMatricula(dfm.getFichaMatricula());
            DetalleFichaMatricula newObject = detalleFichaService.save(dfm);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
