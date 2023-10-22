package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Asistencia;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.*;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController extends GenericControllerImpl<Asistencia, Integer> {
    private AsistenciaService asistenciaService;

    private SelectNative selectNative;

    private ParticipantesMatriculadosService participantesMatriculadosService;

    private CursoService cursoService;

    @Override
    protected GenericService<Asistencia, Integer> getService() {
        return asistenciaService;
    }

    @Autowired
    public AsistenciaController(AsistenciaService asistenciaService, SelectNative selectNative, ParticipantesMatriculadosService participantesMatriculadosService, CursoService cursoService){
        this.asistenciaService = asistenciaService;
        this.selectNative = selectNative;
        this.participantesMatriculadosService = participantesMatriculadosService;
        this.cursoService = cursoService;
    }
    @GetMapping("/findbyId/{id}")
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

    @GetMapping("/fecha/")
    public ResponseEntity<?> getfechaById(){
        LocalDate fecha = LocalDate.now();
        try {

            if(asistenciaService.existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(1,fecha) ){
                return new ResponseEntity<>("encuentro"+fecha, HttpStatus.OK);
            }
            return new ResponseEntity<>("no fecha"+fecha,HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>("err-> "+fecha,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/GenerarAsistencia/{idCurso}")
    public ResponseEntity<?> generarAsistenciaPorFecha(@PathVariable("idCurso") Integer idCurso){
        LocalDate fecha = LocalDate.now();
        //LocalDate fechaPrueba = LocalDate.parse("2023-04-30");
        try {
            Curso curso = cursoService.findById(idCurso);
            if(fecha.isAfter(curso.getFechaFinalizacionCurso())){
                return new ResponseEntity<>(asistenciaService.findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso, curso.getFechaFinalizacionCurso()), HttpStatus.OK);
                //System.out.println("despues-> ");
            }else {
                //if(asistenciaService.findByFechaAsistencia(fecha) ){
                if(asistenciaService.existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso, fecha)){
                    return new ResponseEntity<>(asistenciaService.findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso,fecha), HttpStatus.OK);
                }else{
                    List<PartipantesMatriculados> partipantesMatriculadosList = participantesMatriculadosService.findByInscritoCursoIdCurso(idCurso);
                    List<Asistencia> asistenciaList = new ArrayList<>();

                    if(partipantesMatriculadosList != null){
                        for (PartipantesMatriculados partipantesMatriculados: partipantesMatriculadosList){
                            Asistencia asistencia = new Asistencia();
                            asistencia.setFechaAsistencia(LocalDate.now());
                            asistencia.setPartipantesMatriculados(partipantesMatriculados);
                            asistencia.setEstadoAsistencia(false);
                            asistencia.setObservacionAsistencia("");
                            System.out.println(asistencia.getFechaAsistencia());
                            asistenciaList.add(asistenciaService.save(asistencia));
                        }
                    }
                    return new ResponseEntity<>(asistenciaList,HttpStatus.OK);
                }
                    //System.out.println("antes-> ");
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/obtenerAsistenciaAnteriores/{idCurso}/{fecha}")
    public ResponseEntity<?> obtenerAsistenciaPorFechaCurso(@PathVariable("idCurso") Integer idCurso, @PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha) {
        try {
            List<Asistencia> asistenciaList = asistenciaService.findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso, fecha);
            if (asistenciaList != null) {
                return new ResponseEntity<>(asistenciaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Asistencia> actualizarAsistencia(@PathVariable("id") Integer id, @RequestBody Asistencia asistencia) {
        try {

            Asistencia asistencia1 = asistenciaService.findById(id);
            if(asistencia1 != null){
                asistencia1.setObservacionAsistencia(asistencia.getObservacionAsistencia());
                asistencia1.setEstadoAsistencia(asistencia.getEstadoAsistencia());
                asistencia1.setPartipantesMatriculados(asistencia.getPartipantesMatriculados());
                return new ResponseEntity<>(asistenciaService.save(asistencia1), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/GenerarAsistencia2/{idCurso}/{fecha}")
    public ResponseEntity<?> generarAsistenciaPorFecha2(@PathVariable("idCurso") Integer idCurso,@PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha){
        //LocalDate fechaPrueba = LocalDate.parse("2023-04-30");
        try {
            Curso curso = cursoService.findById(idCurso);
            if(fecha.isAfter(curso.getFechaFinalizacionCurso())){
                return new ResponseEntity<>(asistenciaService.findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso, curso.getFechaFinalizacionCurso()), HttpStatus.OK);
                //System.out.println("despues-> ");
            }else {
                //if(asistenciaService.findByFechaAsistencia(fecha) ){
                if(asistenciaService.existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso, fecha)){
                    return new ResponseEntity<>(asistenciaService.findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso,fecha), HttpStatus.OK);
                }else{
                    List<PartipantesMatriculados> partipantesMatriculadosList = participantesMatriculadosService.findByInscritoCursoIdCurso(idCurso);
                    List<Asistencia> asistenciaList = new ArrayList<>();

                    if(partipantesMatriculadosList != null){
                        for (PartipantesMatriculados partipantesMatriculados: partipantesMatriculadosList){
                            Asistencia asistencia = new Asistencia();
                            asistencia.setFechaAsistencia(fecha);
                            asistencia.setPartipantesMatriculados(partipantesMatriculados);
                            asistencia.setEstadoAsistencia(false);
                            asistencia.setObservacionAsistencia("");
                            System.out.println(asistencia.getFechaAsistencia());
                            asistenciaList.add(asistenciaService.save(asistencia));
                        }
                    }
                    return new ResponseEntity<>(asistenciaList,HttpStatus.OK);
                }
                //System.out.println("antes-> ");
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/obtenerAsistenciaFinal/{id}")
    public List<Map<String, Object>> obtenerAsistenciaFinal(@PathVariable("id") Long id) {
        List<Map<String, Object>> resultados = selectNative.ejecutarConsultaSql(id);
        return resultados;
    }

}
