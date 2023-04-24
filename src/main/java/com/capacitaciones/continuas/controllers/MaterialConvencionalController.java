package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.MaterialConvencional;
import com.capacitaciones.continuas.services.MaterialConvencionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class MaterialConvencionalController {
    @Autowired
    private MaterialConvencionalService materialConvencionalService;

    @GetMapping("/materialConvencional/list")
    public ResponseEntity<List<MaterialConvencional>> listMaterialConvencional(){
        try {
            return new ResponseEntity<>(materialConvencionalService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/materialConvencional/save")
    public ResponseEntity<MaterialConvencional> saveMaterialConvencional(@RequestBody MaterialConvencional materialConvencional){
        try {
            return new ResponseEntity<>(materialConvencionalService.save(materialConvencional), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
