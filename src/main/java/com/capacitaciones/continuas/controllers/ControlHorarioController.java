package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.ContenidoSilabo;
import com.capacitaciones.continuas.models.ControlHorario;
import com.capacitaciones.continuas.services.ContenidoSilaboService;
import com.capacitaciones.continuas.services.ControlHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ControlHorarioController {
    @Autowired
    private ControlHorarioService controlHorarioService;

    @GetMapping("/controlHorario/list")
    public ResponseEntity<List<ControlHorario>> listControlHorario(){
        try {
            return new ResponseEntity<>(controlHorarioService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/controlHorario/save")
    public ResponseEntity<ControlHorario> saveControlHorario(@RequestBody ControlHorario controlHorario){
        try {
            return new ResponseEntity<>(controlHorarioService.save(controlHorario), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
