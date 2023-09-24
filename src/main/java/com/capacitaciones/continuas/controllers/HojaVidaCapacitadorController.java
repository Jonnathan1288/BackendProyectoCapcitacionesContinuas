package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.interfaces.HojaVida;
import com.capacitaciones.continuas.services.CapacitadorService;
import com.capacitaciones.continuas.services.HojaVidaCapacitadorService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class HojaVidaCapacitadorController extends GenericControllerImpl<HojaVidaCapacitador, Integer> {
    private HojaVidaCapacitadorService hojaVidaCapacitadorService;
    private CapacitadorService capacitadorService;

    @Override
    protected GenericService<HojaVidaCapacitador, Integer> getService() {
        return hojaVidaCapacitadorService;
    }

    @Autowired
    public HojaVidaCapacitadorController(HojaVidaCapacitadorService hojaVidaCapacitadorService, CapacitadorService capacitadorService){
        this.hojaVidaCapacitadorService = hojaVidaCapacitadorService;
        this.capacitadorService = capacitadorService;
    }

    @GetMapping("/hojaVidaCapcitadorValidar/findbyIdUsuario/{id}")
    public boolean hojaVidaCapcitadorValidar(@PathVariable("id") Integer id){
        return hojaVidaCapacitadorService.findByCapacitadorUsuarioIdUsuario(id);
    }

    @GetMapping("/findDocumentByIdUsuario/{id}")
    public ResponseEntity<HojaVida> findDocumentByIdUsuario(@PathVariable("id") Integer id){
        try {

            return new ResponseEntity<>(hojaVidaCapacitadorService.findHojaVidaByIdUsuario(id), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


     /*@GetMapping("/hojaVidaCapcitador/findbyIdCapacitador/{id}")
    public ResponseEntity<?> getHojaVidaCapacitadorByIdCapacitador(@PathVariable("id") Integer id){
        try {
            HojaVidaCapacitador dc = hojaVidaCapacitadorService.findHojaVidaCapacitadorByCapacitador_IdCapacitador(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("hojaVidaCapcitador NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @GetMapping("/hojaVidaCapcitador/findbyCapacitdorUsuarioId/{id}")
    public ResponseEntity<?> getHojaVidaCapacitadorUsuarioById(@PathVariable("id") Integer id){
        try {
            HojaVidaCapacitador dc = hojaVidaCapacitadorService.findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("hojaVidaCapcitador NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

}
