package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.PrerequisitoCurso;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.PrerequisitoCursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/prerequisitoCurso")
public class PrerequisitoCursoController extends GenericControllerImpl<PrerequisitoCurso, Integer> {
    @Autowired
    private PrerequisitoCursoService prerequisitoCursoService;

    @Override
    protected GenericService<PrerequisitoCurso, Integer> getService() {
        return prerequisitoCursoService;
    }

    @Autowired
    public PrerequisitoCursoController(PrerequisitoCursoService prerequisitoCursoService){
        this.prerequisitoCursoService = prerequisitoCursoService;

    }


    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getPrerequisitoCursoById(@PathVariable("id") Integer id){
        try {
            PrerequisitoCurso pr = prerequisitoCursoService.findById(id);
            if(pr != null){
                return new ResponseEntity<>(pr, HttpStatus.OK);
            }
            return new ResponseEntity<>("PREREQUISITO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyIdCurso/{id}")
    public ResponseEntity<?> getPrerequisitoCursoByIdCurso(@PathVariable("id") Integer id){
        try {
            List<PrerequisitoCurso> pr = prerequisitoCursoService.findByCursoIdCurso(id);
            if(pr != null){
                return new ResponseEntity<>(pr, HttpStatus.OK);
            }
            return new ResponseEntity<>("PREREQUISITO DEL CURSO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PrerequisitoCurso> actualizarPrerequisitoCurso(@PathVariable Integer id, @RequestBody PrerequisitoCurso prerequisitoCurso) {
        try {
            if (prerequisitoCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            prerequisitoCurso.setNombrePrerequisitoCurso(prerequisitoCurso.getNombrePrerequisitoCurso());
            prerequisitoCurso.setEstadoPrerequisitoCurso(prerequisitoCurso.getEstadoPrerequisitoCurso());
            return new ResponseEntity<>(prerequisitoCursoService.save(prerequisitoCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
