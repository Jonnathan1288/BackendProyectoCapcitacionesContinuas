package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.NivelCurso;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.NivelCursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/nivelCurso")
public class NivelCursoController extends GenericControllerImpl<NivelCurso, Integer> {
    @Autowired
    private NivelCursoService nivelCursoService;

    @Override
    protected GenericService<NivelCurso, Integer> getService() {
        return nivelCursoService;
    }

    @Autowired
    public NivelCursoController(NivelCursoService nivelCursoService){
        this.nivelCursoService = nivelCursoService;

    }



    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getNivelCursoById(@PathVariable("id") Integer id){
        try {
            NivelCurso nc = nivelCursoService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NIVEL CURSO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<NivelCurso> actualizarNivelCurso(@PathVariable Integer id, @RequestBody NivelCurso nivelCurso) {
        try {
            if (nivelCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            nivelCurso.setNombreNivelCurso(nivelCurso.getNombreNivelCurso());
            nivelCurso.setEstadoNivelCurso(nivelCurso.getEstadoNivelCurso());

            return new ResponseEntity<>(nivelCursoService.save(nivelCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
