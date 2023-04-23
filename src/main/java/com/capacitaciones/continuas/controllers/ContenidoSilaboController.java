package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.ContenidoSilabo;
import com.capacitaciones.continuas.services.ContenidoSilaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ContenidoSilaboController {
    @Autowired
    private ContenidoSilaboService contenidoSilaboService;

    @GetMapping("/contenidosilabo/list")
    public ResponseEntity<List<ContenidoSilabo>> listContenidoSilabo(){
        try {
            return new ResponseEntity<>(contenidoSilaboService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contenidosilabo/save")
    public ResponseEntity<ContenidoSilabo> saveContenidoSilabo(@RequestBody ContenidoSilabo contenidoSilabo){
        try {
            return new ResponseEntity<>(contenidoSilaboService.save(contenidoSilabo), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
