package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Area;
import com.capacitaciones.continuas.models.Asistencia;
import com.capacitaciones.continuas.services.AreaService;
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
}
