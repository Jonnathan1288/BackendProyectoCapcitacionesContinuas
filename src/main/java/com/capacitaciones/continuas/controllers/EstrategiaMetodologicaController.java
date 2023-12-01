package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.EstrategiasMetodologica;
import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.EstrategiaMetodologicaService;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/estrategiaMetodologica")
public class EstrategiaMetodologicaController extends GenericControllerImpl<EstrategiasMetodologica, Integer> {
    @Autowired
    private EstrategiaMetodologicaService estrategiaMetodologicaService;

    @Override
    protected GenericService<EstrategiasMetodologica, Integer> getService() {
        return estrategiaMetodologicaService;
    }

    @Autowired
    public EstrategiaMetodologicaController(EstrategiaMetodologicaService estrategiaMetodologicaService){
        this.estrategiaMetodologicaService = estrategiaMetodologicaService;

    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getEstrategiaMetodologicaById(@PathVariable("id") Integer id){
        try {
            EstrategiasMetodologica dc = estrategiaMetodologicaService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("estrategiaMetodologica NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/strategiaMetodologicaPorSilabo/findbyId/{IdSilabo}")
    public ResponseEntity<?> getResultadosPorSilabo(@PathVariable("IdSilabo") Integer IdSilabo){
        try {
            List<EstrategiasMetodologica> nc = estrategiaMetodologicaService.findBySilaboIdSilabo(IdSilabo);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EstrategiasMetodologica> actualizarEspecialidad(@PathVariable Integer id, @RequestBody EstrategiasMetodologica estrategism) {
        try {
            if (estrategiaMetodologicaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            estrategism.setNombreEstrategiaMetodologica(estrategism.getNombreEstrategiaMetodologica());
            estrategism.setFinalidadEstrategiaMetodologica(estrategism.getFinalidadEstrategiaMetodologica());
            estrategism.setSilabo(estrategism.getSilabo());

            EstrategiasMetodologica newObject = estrategiaMetodologicaService.save(estrategism);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
