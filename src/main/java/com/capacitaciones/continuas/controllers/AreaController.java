package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Area;
import com.capacitaciones.continuas.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/area/list")
    public ResponseEntity<List<Area>> listArea(){
        try {
            return new ResponseEntity<>(areaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/area/findbyId/{id}")
    public ResponseEntity<?> getAreaById(@PathVariable("id") Integer id){
        try {
            Area area = areaService.findById(id);
            if(area != null){
                return new ResponseEntity<>(area, HttpStatus.OK);
            }
            return new ResponseEntity<>("AREA NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/area/save")
    public ResponseEntity<Area> saveArea(@RequestBody Area area){
        try {
            return new ResponseEntity<>(areaService.save(area), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
