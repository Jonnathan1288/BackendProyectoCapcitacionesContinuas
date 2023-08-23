package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.Modelos.Primary.Recurso;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.InstalacionService;
import com.capacitaciones.continuas.services.RecursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/recurso")
public class RecursoController extends GenericControllerImpl<Recurso, Integer> {


    private RecursoService recursoService;

    @Autowired
    public RecursoController(RecursoService recursoService){
        this.recursoService = recursoService;

    }

    @Override
    protected GenericService<Recurso, Integer> getService() {
        return recursoService;
    }
}
