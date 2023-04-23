package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Capacitador;
import com.capacitaciones.continuas.models.Certificado;
import com.capacitaciones.continuas.services.CapacitadorService;
import com.capacitaciones.continuas.services.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class CertificadoController {
    @Autowired
    private CertificadoService certificadoService;

    @GetMapping("/certificado/list")
    public ResponseEntity<List<Certificado>> listCertificado(){
        try {
            return new ResponseEntity<>(certificadoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/certificado/save")
    public ResponseEntity<Certificado> saveCertificado(@RequestBody Certificado certificado){
        try {
            return new ResponseEntity<>(certificadoService.save(certificado), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
