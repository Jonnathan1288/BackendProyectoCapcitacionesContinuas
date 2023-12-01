package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.PeriodoPrograma;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.PeriodoProgramaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/periodoPrograma")
public class PeriodoProgramaController extends GenericControllerImpl<PeriodoPrograma, Integer> {
    @Autowired
    private PeriodoProgramaService periodoProgramaService;

    @Override
    protected GenericService<PeriodoPrograma, Integer> getService() {
        return periodoProgramaService;
    }

    @Autowired
    public PeriodoProgramaController(PeriodoProgramaService periodoProgramaService){
        this.periodoProgramaService = periodoProgramaService;

    }



    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getPeriodoProgramaById(@PathVariable("id") Integer id){
        try {
            PeriodoPrograma nc = periodoProgramaService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PERIODO PROGRAMA APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PeriodoPrograma> actualizarPeriodoPrograma(@PathVariable Integer id, @RequestBody PeriodoPrograma periodoPrograma) {
        try {
            if (periodoProgramaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            periodoPrograma.setNombrePeriodoPrograma(periodoPrograma.getNombrePeriodoPrograma());
            periodoPrograma.setEstadoPeriodoPrograma(periodoPrograma.getEstadoPeriodoPrograma());

            return new ResponseEntity<>(periodoProgramaService.save(periodoPrograma), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
