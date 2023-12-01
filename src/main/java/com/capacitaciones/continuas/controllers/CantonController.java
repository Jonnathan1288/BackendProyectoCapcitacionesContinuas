package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Canton;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.CantonService;
import com.capacitaciones.continuas.services.ParroquiaService;
import com.capacitaciones.continuas.services.RecursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/canton")
public class CantonController extends GenericControllerImpl<Canton,Integer> {
    @Autowired
    private CantonService cantonService;

    @Override
    protected GenericService<Canton, Integer> getService() {
        return cantonService;
    }

    @Autowired
    public CantonController(CantonService cantonService){
        this.cantonService = cantonService;

    }



    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getCantonById(@PathVariable("id") Integer id){
        try {
            Canton canton = cantonService.findById(id);
            if(canton != null){
                return new ResponseEntity<>(canton, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyIdProvincia/{id}")
    public ResponseEntity<List<Canton>> getCantonByIdProvincia(@PathVariable("id") Integer id){
        try {
            List<Canton> canton = cantonService.findByProvinciaIdProvincia(id);
            if(canton != null){
                return new ResponseEntity<>(canton, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Canton> actualizarParroquia(@PathVariable Integer id, @RequestBody Canton canton) {
        try {
            if (cantonService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            canton.setCanton(canton.getCanton());
            return new ResponseEntity<>(cantonService.save(canton), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
