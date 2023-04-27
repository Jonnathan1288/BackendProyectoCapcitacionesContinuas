package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.DisenioCurricular;
import com.capacitaciones.continuas.services.DisenioCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class DisenioCurricularController {
    @Autowired
    private DisenioCurricularService disenioCurricularService;

    @GetMapping("/disenioCurricular/list")
    public ResponseEntity<List<DisenioCurricular>> listDisenioCurricular(){
        try {
            return new ResponseEntity<>(disenioCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/disenioCurricular/findbyId/{id}")
    public ResponseEntity<?> getDisenioCurricularById(@PathVariable("id") Integer id){
        try {
            DisenioCurricular dc = disenioCurricularService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>(" disenioCurricular NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/disenioCurricular/save")
    public ResponseEntity<DisenioCurricular> saveDisenioCurricular(@RequestBody DisenioCurricular disenioCurricular){
        try {
            return new ResponseEntity<>(disenioCurricularService.save(disenioCurricular), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/disenioCurricular/update/{id}")
    public ResponseEntity<DisenioCurricular> actualizarDisenioCurricular(@PathVariable Integer id, @RequestBody DisenioCurricular dc) {
        try {
            if (disenioCurricularService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            dc.setTemasTransversales(dc.getTemasTransversales());
            dc.setEstrategiasAprendizaje(dc.getEstrategiasAprendizaje());
            dc.setEstadoDisenioCurricular(dc.getEstadoDisenioCurricular());
            DisenioCurricular newObject = disenioCurricularService.save(dc);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
