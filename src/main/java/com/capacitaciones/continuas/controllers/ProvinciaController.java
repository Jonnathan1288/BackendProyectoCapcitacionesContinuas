package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Provincia;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.ProvinciaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController extends GenericControllerImpl<Provincia, Integer> {
    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    public ProvinciaController(ProvinciaService provinciaService){
        this.provinciaService = provinciaService;

    }

    @Override
    protected GenericService<Provincia, Integer> getService() {
        return provinciaService;
    }


    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getProvinciaById(@PathVariable("id") Integer id){
        try {
            Provincia provincia = provinciaService.findById(id);
            if(provincia != null){
                return new ResponseEntity<>(provincia, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Provincia> actualizarProvincia(@PathVariable Integer id, @RequestBody Provincia provincia) {
        try {
            if (provinciaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            provincia.setProvincia(provincia.getProvincia());

            return new ResponseEntity<>(provinciaService.save(provincia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
