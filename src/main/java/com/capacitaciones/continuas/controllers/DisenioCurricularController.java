package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.DisenioCurricular;
import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.DisenioCurricularService;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/disenioCurricular")
public class DisenioCurricularController extends GenericControllerImpl<DisenioCurricular, Integer> {
    @Autowired
    private DisenioCurricularService disenioCurricularService;

    @Override
    protected GenericService<DisenioCurricular, Integer> getService() {
        return disenioCurricularService;
    }

    @Autowired
    public DisenioCurricularController(DisenioCurricularService disenioCurricularService){
        this.disenioCurricularService = disenioCurricularService;

    }


    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getDisenioCurricularById(@PathVariable("id") Integer id){
        try {
            DisenioCurricular dc = disenioCurricularService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>(" disenioCurricular NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyIdSilaboCurso/{id}")
    public ResponseEntity<?> getDisenioCurricularBySilaboCursoId(@PathVariable("id") Integer id){
        try {
            DisenioCurricular dc = disenioCurricularService.findBySilaboCursoIdCurso(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DisenioCurricular> actualizarDisenioCurricular(@PathVariable Integer id, @RequestBody DisenioCurricular dc) {
        try {
            if (disenioCurricularService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            dc.setTemasTransversales(dc.getTemasTransversales());
            dc.setEstrategiasAprendizaje(dc.getEstrategiasAprendizaje());
            dc.setEstadoDisenioCurricular(dc.getEstadoDisenioCurricular());
            DisenioCurricular newObject = disenioCurricularService.save(dc);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Implementacion de nuevos metodos
    @GetMapping("/findbyIdSilaboPorDisenioCurricular/{id}")
    public ResponseEntity<?> DisenioCurricularFindByIdPorSilabo(@PathVariable("id") Integer id){
        try {
            DisenioCurricular nc = disenioCurricularService.DisenioCurricularfindBySilaboIdSilabo(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("DISEÑO CURRICULAR NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyIdSilabo/{idSilabo}")
    public boolean DisenioCurricularfindbyIdSilabo(@PathVariable("idSilabo") Integer idSilabo){
        return disenioCurricularService.findBySilaboIdSilabo(idSilabo);
    }


}
