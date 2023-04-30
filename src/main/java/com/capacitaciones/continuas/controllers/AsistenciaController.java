package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Asistencia;
import com.capacitaciones.continuas.models.ParticipantesAprobados;
import com.capacitaciones.continuas.models.PartipantesMatriculados;
import com.capacitaciones.continuas.services.AsistenciaService;
import com.capacitaciones.continuas.services.ParticipantesMatriculadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private ParticipantesMatriculadosService participantesMatriculadosService;

    @GetMapping("/asistencia/list")
    public ResponseEntity<List<Asistencia>> listAsistencia(){
        try {
            return new ResponseEntity<>(asistenciaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/asistencia/save")
    public ResponseEntity<Asistencia> saveAsistencia(@RequestBody Asistencia asistencia){
        try {
            return new ResponseEntity<>(asistenciaService.save(asistencia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/asistencia/findbyId/{id}")
    public ResponseEntity<?> getAsistenciaById(@PathVariable("id") Integer id){
        try {
            Asistencia asistencia = asistenciaService.findById(id);
            if(asistencia != null){
                return new ResponseEntity<>(asistencia, HttpStatus.OK);
            }
            return new ResponseEntity<>("ASISTENCIA NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/asistencia/fecha/")
    public ResponseEntity<?> getfechaById(){
        LocalDate fecha = LocalDate.now();
        try {

            if(asistenciaService.findByFechaAsistencia(fecha) ){
                return new ResponseEntity<>("encuentro"+fecha, HttpStatus.OK);
            }
            return new ResponseEntity<>("no fecha"+fecha,HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>("err-> "+fecha,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/asistencia/GenerarAsistencia/{idCurso}")
    public ResponseEntity<?> generarAsistenciaPorFecha(@PathVariable("idCurso") Integer idCurso){
        LocalDate fecha = LocalDate.now();
        //LocalDate fechaPrueba = LocalDate.parse("2023-04-30");
        try {
            if(asistenciaService.findByFechaAsistencia(fecha) ){
                return new ResponseEntity<>(asistenciaService.findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso,fecha), HttpStatus.OK);
            }else{
                List<PartipantesMatriculados> partipantesMatriculadosList = participantesMatriculadosService.findByInscritoCursoIdCurso(idCurso);

                if(partipantesMatriculadosList != null){
                    for (PartipantesMatriculados partipantesMatriculados: partipantesMatriculadosList){
                        Asistencia asistencia = new Asistencia();
                        asistencia.setFechaAsistencia(LocalDate.now());
                        asistencia.setPartipantesMatriculados(partipantesMatriculados);
                        asistencia.setEstadoAsistencia(false);
                        asistencia.setObservacionAsistencia("");
                        System.out.println(asistencia.getFechaAsistencia());
                        asistenciaService.save(asistencia);
                    }
                }
                return new ResponseEntity<>(participantesMatriculadosService.findByInscritoCursoIdCurso(idCurso),HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/asistencia/actualizar/{id}")
    public ResponseEntity<Asistencia> actualizarAsistencia(@PathVariable Integer id, @RequestBody Asistencia asistencia) {
        try {
            if (asistenciaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            asistencia.setObservacionAsistencia(asistencia.getObservacionAsistencia());
            asistencia.setEstadoAsistencia(asistencia.getEstadoAsistencia());
            Asistencia newObject = asistenciaService.save(asistencia);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
