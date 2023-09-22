package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Especialidad;
import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.EspecialidadService;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadController extends GenericControllerImpl<Especialidad, Integer> {
    @Autowired
    private EspecialidadService especialidadService;

    @Override
    protected GenericService<Especialidad, Integer> getService() {
        return especialidadService;
    }

    @Autowired
    public EspecialidadController(EspecialidadService especialidadService){
        this.especialidadService = especialidadService;

    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getespecialidadById(@PathVariable("id") Integer id){
        try {
            Especialidad dc = especialidadService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("especialidad NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyIdArea/{id}")
    public ResponseEntity<List<Especialidad>> getespecialidadByIdArea(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(especialidadService.findByAreaIdArea(id),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        try {
            if (especialidadService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            especialidad.setCodigoEspecialidad(especialidad.getCodigoEspecialidad());
            especialidad.setNombreEspecialidad(especialidad.getNombreEspecialidad());
            especialidad.setEstadoEspecialidadActivo(especialidad.getEstadoEspecialidadActivo());
            especialidad.setArea(especialidad.getArea());
            Especialidad newObject = especialidadService.save(especialidad);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
