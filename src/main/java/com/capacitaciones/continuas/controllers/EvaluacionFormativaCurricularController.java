package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.EvaluacionFormativaCurricularService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/evaluacionFormativaCurricular")
public class EvaluacionFormativaCurricularController extends GenericControllerImpl<EvalucionFormativaCurricular, Integer> {
    @Autowired
    private EvaluacionFormativaCurricularService evaluacionFormativaCurricularService;

    @Override
    protected GenericService<EvalucionFormativaCurricular, Integer> getService() {
        return evaluacionFormativaCurricularService;
    }

    @Autowired
    public EvaluacionFormativaCurricularController(EvaluacionFormativaCurricularService evaluacionFormativaCurricularService){
        this.evaluacionFormativaCurricularService = evaluacionFormativaCurricularService;

    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getEvalucionFormativaCurricularById(@PathVariable("id") Integer id){
        try {
            EvalucionFormativaCurricular dc = evaluacionFormativaCurricularService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("evaluacionFormativaCurricular NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EvalucionFormativaCurricular> actualizarEvalucionFormativaCurricular(@PathVariable Integer id, @RequestBody EvalucionFormativaCurricular evadiag) {
        try {
            if (evaluacionFormativaCurricularService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            evadiag.setTecnicaFormativa(evadiag.getTecnicaFormativa());
            evadiag.setInstrumnetoFormativa(evadiag.getInstrumnetoFormativa());
            evadiag.setDisenioCurricular(evadiag.getDisenioCurricular());
            EvalucionFormativaCurricular newObject = evaluacionFormativaCurricularService.save(evadiag);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //impl
    @GetMapping("/evaluacionFormativaporDisenioCurricular/findbyId/{idDisenioCurricular}")
    public ResponseEntity<?> getEvaluacionFormativaPorDisenioCurricular(@PathVariable("idDisenioCurricular") Integer idDisenioCurricular){
        try {
            List<EvalucionFormativaCurricular> nc = evaluacionFormativaCurricularService.findByDisenioCurricularIdDisenioCurricular(idDisenioCurricular);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
