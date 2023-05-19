package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Persona;
import com.capacitaciones.continuas.services.EmailServiceImpl;
import com.capacitaciones.continuas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private PersonaService personaservice;

    @GetMapping("/email/sendRecuperacionPassword/{cedula}")
    public ResponseEntity<?> sendEmailREcuperacion(@PathVariable("cedula") Integer cedula){
        try {
            Persona pe= personaservice.findById(cedula);
            if(pe != null) {
                if(emailService.sendEmail(pe)==true) {
                    return new ResponseEntity<>("Enviado Exitosamente", HttpStatus.OK);
                }else {
                    return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INCONVENIENTE");
                }
            }else {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND");
            }
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR DE SERVIDOR");
        }

    }


}
