package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.MaterialAudiovisual;
import com.capacitaciones.continuas.models.MaterialConvencional;
import com.capacitaciones.continuas.services.MaterialAudiovisualService;
import com.capacitaciones.continuas.services.MaterialConvencionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class MaterialAudiovisualController {
    @Autowired
    private MaterialAudiovisualService materialAudiovisualService;

    @GetMapping("/materialAudiovisual/list")
    public ResponseEntity<List<MaterialAudiovisual>> listMaterialAudiovisual(){
        try {
            return new ResponseEntity<>(materialAudiovisualService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/materialAudiovisual/save")
    public ResponseEntity<MaterialAudiovisual> saveMaterialAudiovisual(@RequestBody MaterialAudiovisual materialAudiovisual){
        try {
            return new ResponseEntity<>(materialAudiovisualService.save(materialAudiovisual), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
