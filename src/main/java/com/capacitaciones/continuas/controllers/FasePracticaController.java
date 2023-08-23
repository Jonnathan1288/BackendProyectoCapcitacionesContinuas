package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.FaseTeoricaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fasePractica")
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
}
