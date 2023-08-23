package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.Modelos.Primary.Recurso;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.FaseTeoricaService;
import com.capacitaciones.continuas.services.RecursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/faseTeorica")
public class FaseTeoricaController extends GenericControllerImpl<FaseTeorica, Integer> {


    private FaseTeoricaService faseTeoricaService;

    @Autowired
    public FaseTeoricaController(FaseTeoricaService faseTeoricaService){
        this.faseTeoricaService = faseTeoricaService;

    }

    @Override
    protected GenericService<FaseTeorica, Integer> getService() {
        return faseTeoricaService;
    }
}
