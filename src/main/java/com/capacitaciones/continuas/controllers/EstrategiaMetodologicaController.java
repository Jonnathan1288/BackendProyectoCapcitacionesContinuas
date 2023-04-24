package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.EstrategiasMetodologica;
import com.capacitaciones.continuas.services.EstrategiaMetodologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class EstrategiaMetodologicaController {
    @Autowired
    private EstrategiaMetodologicaService estrategiaMetodologicaService;

    @GetMapping("/estrategiaMetodologica/list")
    public ResponseEntity<List<EstrategiasMetodologica>> listEstrategiaMetodologica(){
        try {
            return new ResponseEntity<>(estrategiaMetodologicaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/strategiaMetodologica/save")
    public ResponseEntity<EstrategiasMetodologica> saveEstrategiaMetodologica(@RequestBody EstrategiasMetodologica estrategiasMetodologica){
        try {
            return new ResponseEntity<>(estrategiaMetodologicaService.save(estrategiasMetodologica), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
