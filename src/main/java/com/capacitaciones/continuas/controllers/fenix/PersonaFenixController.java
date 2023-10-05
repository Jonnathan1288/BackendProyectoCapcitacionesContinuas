package com.capacitaciones.continuas.controllers.fenix;

import com.capacitaciones.continuas.Modelos.Secondary.EstudianteFenix;
import com.capacitaciones.continuas.Modelos.Secondary.PersonaFenix;
import com.capacitaciones.continuas.services.EstudianteFenixService;
import com.capacitaciones.continuas.services.PersonaFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fenix")
public class PersonaFenixController {
    private PersonaFenixService personaFenixService;

    @Autowired
    public PersonaFenixController(PersonaFenixService personaFenixService){
        this.personaFenixService = personaFenixService;
    }

    @GetMapping("/person/all")
    public ResponseEntity<List<PersonaFenix>> findAll(){
        try {
            return new ResponseEntity<>(personaFenixService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/byIdentificacion/{ci}")
    public ResponseEntity<PersonaFenix> byIdentificacion(@PathVariable("ci") String ci){
        try {
            return new ResponseEntity<>(personaFenixService.findByIdentificacion(ci), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
