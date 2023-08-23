package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.AreaService;
import com.capacitaciones.continuas.services.InstalacionService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/instalacion")
public class InstalacionController extends GenericControllerImpl<Instalacion, Integer> {


    private InstalacionService instalacionService;

    @Autowired
    public InstalacionController(InstalacionService instalacionService){
        this.instalacionService = instalacionService;

    }

    @Override
    protected GenericService<Instalacion, Integer> getService() {
        return instalacionService;
    }
}
