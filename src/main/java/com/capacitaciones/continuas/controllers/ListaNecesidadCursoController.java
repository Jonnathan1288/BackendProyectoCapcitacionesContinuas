package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.ListaNecesidadCurso;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.ListaNecesidadCursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/listaNecesidadCurso")
public class ListaNecesidadCursoController extends GenericControllerImpl<ListaNecesidadCurso, Integer> {
    @Autowired
    private ListaNecesidadCursoService listaNecesidadCursoService;

    @Override
    protected GenericService<ListaNecesidadCurso, Integer> getService() {
        return listaNecesidadCursoService;
    }

    @Autowired
    public ListaNecesidadCursoController(ListaNecesidadCursoService listaNecesidadCursoService){
        this.listaNecesidadCursoService = listaNecesidadCursoService;

    }


    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getListaNecesidadCursoById(@PathVariable("id") Integer id){
        try {
            ListaNecesidadCurso materialConvencional = listaNecesidadCursoService.findById(id);
            if(materialConvencional != null){
                return new ResponseEntity<>(materialConvencional, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyIdNecesidad/{id}")
    public ResponseEntity<?> findByNecesidadCurso_IdNecesidadCurso(@PathVariable("id") Integer id){
        try {
            List<ListaNecesidadCurso> materialConvencional = listaNecesidadCursoService.findByNecesidadCurso_IdNecesidadCurso(id);
            if(materialConvencional != null){
                return new ResponseEntity<>(materialConvencional, HttpStatus.OK);
            }
            return new ResponseEntity<>("listaNecesidadCurso NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ListaNecesidadCurso> actualizarListaNecesidadCurso(@PathVariable Integer id, @RequestBody ListaNecesidadCurso listaNecesidadCurso) {
        try {
            if (listaNecesidadCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            listaNecesidadCurso.setDetalleNececidadCurso(listaNecesidadCurso.getDetalleNececidadCurso());
            listaNecesidadCurso.setEstadoDetalleNecesidad(listaNecesidadCurso.getEstadoDetalleNecesidad());
            return new ResponseEntity<>(listaNecesidadCursoService.save(listaNecesidadCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
