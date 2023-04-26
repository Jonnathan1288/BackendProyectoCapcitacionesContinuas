package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.InformeFinalCurso;
import com.capacitaciones.continuas.models.Inscrito;
import com.capacitaciones.continuas.services.InscritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "{*}")
@RestController
@RequestMapping("/api")
public class InscritoController {

    @Autowired
    private InscritoService inscritoService;

    @GetMapping("/inscritocurso/listar")
    public ResponseEntity<List<Inscrito>> obtenerLista() {
        try {
            return new ResponseEntity<>(inscritoService.findByAll(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/inscritocurso/findbyId/{id}")
    public ResponseEntity<?> getInformeFinalCursoById(@PathVariable("id") Integer id){
        try {
            Inscrito dc = inscritoService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("inscritocurso NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/inscritocurso/crear")
    public ResponseEntity<Inscrito> crear(@RequestBody Inscrito c) {
        try {
            return new ResponseEntity<>(inscritoService.save(c), HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/inscritocurso/update/{id}")
    public ResponseEntity<Inscrito> actualizarInscrito(@PathVariable Integer id, @RequestBody Inscrito inscrito) {
        try {
            if (inscritoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            inscrito.setFechaInscrito(inscrito.getFechaInscrito());
            inscrito.setEstadoInscrito(inscrito.getEstadoInscrito());
            inscrito.setEstadoInscritoActivo(inscrito.getEstadoInscritoActivo());
            inscrito.setUsuario(inscrito.getUsuario());
            inscrito.setCurso(inscrito.getCurso());
            Inscrito newObject = inscritoService.save(inscrito);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
