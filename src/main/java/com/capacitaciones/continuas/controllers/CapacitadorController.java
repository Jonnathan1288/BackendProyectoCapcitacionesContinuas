package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.CapacitadorService;
import com.capacitaciones.continuas.services.FasePracticaService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/capacitador")
public class CapacitadorController extends GenericControllerImpl<Capacitador, Integer> {

    private CapacitadorService capacitadorService;

    @Autowired
    public CapacitadorController(CapacitadorService capacitadorService){
        this.capacitadorService = capacitadorService;
    }

    @Override
    protected GenericService<Capacitador, Integer> getService() {
        return capacitadorService;
    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getCapacitadorById(@PathVariable("id") Integer id){
        try {
            Capacitador capacitador = capacitadorService.findById(id);
            if(capacitador != null){
                return new ResponseEntity<>(capacitador, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/exists/findbyIdUsuario/{idUsuario}")
    public Boolean getCapacitadorExistsByIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        try {
            if(capacitadorService.existsByUsuarioIdUsuario(idUsuario)){
                return true;
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/findbyIdUsuario/{id}")
    public ResponseEntity<?> findByUsuarioIdUsuario(@PathVariable("id") Integer id){
        try {
            Capacitador capacitador = capacitadorService.findByUsuarioIdUsuario(id);
            if(capacitador != null){
                return new ResponseEntity<>(capacitador, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Capacitador> actualizarCapacitador(@PathVariable Integer id, @RequestBody Capacitador capacitador) {
        try {
            if (capacitadorService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            capacitador.setTituloCapacitador(capacitador.getTituloCapacitador());
            capacitador.setTipoAbreviaturaTitulo(capacitador.getTipoAbreviaturaTitulo());
            capacitador.setEstadoActivoCapacitador(capacitador.getEstadoActivoCapacitador());
            Capacitador newObject = capacitadorService.save(capacitador);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
