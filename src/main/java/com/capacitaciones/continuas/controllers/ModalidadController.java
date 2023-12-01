package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.ModalidadCurso;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.ModalidadCursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/modalidadCurso")
public class ModalidadController extends GenericControllerImpl<ModalidadCurso, Integer> {
    @Autowired
    private ModalidadCursoService modalidadCursoService;

    @Override
    protected GenericService<ModalidadCurso, Integer> getService() {
        return modalidadCursoService;
    }

    @Autowired
    public ModalidadController(ModalidadCursoService modalidadCursoService){
        this.modalidadCursoService = modalidadCursoService;

    }


      @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getModalidadById(@PathVariable("id") Integer id){
        try {
            ModalidadCurso mc = modalidadCursoService.findById(id);
            if(mc != null){
                return new ResponseEntity<>(mc, HttpStatus.OK);
            }
            return new ResponseEntity<>("MODALIDAD NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

      @PutMapping("/actualizar/{id}")
    public ResponseEntity<ModalidadCurso> actualizarMaterialConvencional(@PathVariable Integer id, @RequestBody ModalidadCurso modalidadCurso) {
        try {
            if (modalidadCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            modalidadCurso.setNombreModalidadCurso(modalidadCurso.getNombreModalidadCurso());
            modalidadCurso.setEstadoModalidadCurso(modalidadCurso.getEstadoModalidadCurso());
            return new ResponseEntity<>(modalidadCursoService.save(modalidadCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
