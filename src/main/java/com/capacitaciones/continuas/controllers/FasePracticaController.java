package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.FaseTeoricaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/fasePractica")
public class FasePracticaController extends GenericControllerImpl<FasePractica, Integer> {


    private FasePracticaService fasePracticaService;

    @Autowired
    public FasePracticaController(FasePracticaService fasePracticaService){
        this.fasePracticaService = fasePracticaService;

    }

    @Override
    protected GenericService<FasePractica, Integer> getService() {
        return fasePracticaService;
    }

    @GetMapping("/findAllByDisenioCurricularId/{disenioCurricularId}")
    public ResponseEntity<List<FasePractica>> findAllByDisenioCurricularId(@PathVariable Integer disenioCurricularId) {
        List<FasePractica> fasesPracticas = fasePracticaService.findAllByDisenioCurricularId(disenioCurricularId);
        return ResponseEntity.ok(fasesPracticas);
    }
}
