package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.services.CapacitadorService;
import com.capacitaciones.continuas.services.HojaVidaCapacitadorService;
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
public class HojaVidaCapacitadorController {

    @Autowired
    HojaVidaCapacitadorService hojaVidaCapacitadorService;

    @Autowired
    CapacitadorService capacitadorService;

    @GetMapping("/hojaVidaCapcitador/listar")
    public ResponseEntity<List<HojaVidaCapacitador>> obtenerLista() {
        try {
            return new ResponseEntity<>(hojaVidaCapacitadorService.findByAll(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hojaVidaCapcitador/findbyId/{id}")
    public ResponseEntity<?> getHojaVidaCapacitadorById(@PathVariable("id") Integer id){
        try {
            HojaVidaCapacitador dc = hojaVidaCapacitadorService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("hojaVidaCapcitador NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hojaVidaCapcitadorValidar/findbyIdUsuario/{id}")
    public boolean hojaVidaCapcitadorValidar(@PathVariable("id") Integer id){
        return hojaVidaCapacitadorService.findByCapacitadorUsuarioIdUsuario(id);
    }

    @PostMapping("/hojaVida/saveDocumento/{idUsuario}")
    public ResponseEntity<?> guardarCV(@RequestParam("file") MultipartFile file,@PathVariable("idUsuario") Integer idUsuario) throws IOException {
        Capacitador capacitador = capacitadorService.findByUsuarioIdUsuario(idUsuario);
        if(capacitador == null){
            return ResponseEntity.badRequest().body("No se encontro CAPACITADOR.");
        }
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ningún archivo.");
        }
        byte[] bytesDocumento = file.getBytes();
        return new ResponseEntity<>(hojaVidaCapacitadorService.guardarCV(bytesDocumento,capacitador), HttpStatus.CREATED);
    }

    @PostMapping("/hojaVidaCapcitador/crear")
    public ResponseEntity<HojaVidaCapacitador> crear(@RequestBody HojaVidaCapacitador c) {
        try {
            return new ResponseEntity<>(hojaVidaCapacitadorService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/hojaVidaCapcitador/update/{id}")
    public ResponseEntity<HojaVidaCapacitador> actualizarHojaVidaCapacitador(@PathVariable Integer id, @RequestBody HojaVidaCapacitador hojavida) {
        try {
            if (hojaVidaCapacitadorService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            hojavida.setExperiencialLaboral(hojavida.getExperiencialLaboral());
            hojavida.setSobreMi(hojavida.getSobreMi());
            hojavida.setExperienciaEscolar(hojavida.getExperienciaEscolar());
            hojavida.setDestrezas(hojavida.getDestrezas());
            hojavida.setIdiomas(hojavida.getIdiomas());
            hojavida.setCapacitador(hojavida.getCapacitador());
            HojaVidaCapacitador newObject = hojaVidaCapacitadorService.save(hojavida);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
