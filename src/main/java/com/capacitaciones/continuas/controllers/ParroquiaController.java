package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.AreaService;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.ParroquiaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/parroquia")
public class ParroquiaController extends GenericControllerImpl<Parroquia, Integer> {
    @Autowired
    private ParroquiaService parroquiaService;

    @Override
    protected GenericService<Parroquia, Integer> getService() {
        return parroquiaService;
    }

    @Autowired
    public ParroquiaController(ParroquiaService parroquiaService){
        this.parroquiaService = parroquiaService;

    }


    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getParroquiaById(@PathVariable("id") Integer id){
        try {
            Parroquia parroquia = parroquiaService.findById(id);
            if(parroquia != null){
                return new ResponseEntity<>(parroquia, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyIdCanton/{id}")
    public ResponseEntity<List<Parroquia>> getParroquiaByIdCanton(@PathVariable("id") Integer id){
        try {
            List<Parroquia> parroquia = parroquiaService.findByCanton_IdCanton(id);
            if(parroquia != null){
                return new ResponseEntity<>(parroquia, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Parroquia> actualizarParroquia(@PathVariable Integer id, @RequestBody Parroquia parroquia) {
        try {
            if (parroquiaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            parroquia.setParroquia(parroquia.getParroquia());
            parroquia.setCanton(parroquia.getCanton());
            return new ResponseEntity<>(parroquiaService.save(parroquia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
