package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.AreaService;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/area")
public class AreaController extends GenericControllerImpl<Area, Integer> {
    private AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService){
        this.areaService = areaService;
    }
    @Override
    protected GenericService<Area, Integer> getService() {
        return areaService;
    }

    @GetMapping("/findbyId/{id}")
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



    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Area> actualizarArea(@PathVariable Integer id, @RequestBody Area area) {
        try {
        if (areaService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
            area.setNombreArea(area.getNombreArea());
            area.setEstadoAreaActivo(area.getEstadoAreaActivo());
            return new ResponseEntity<>(areaService.save(area), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
