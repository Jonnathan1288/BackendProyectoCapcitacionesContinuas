package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.interfaces.CoursesFilterByDocente;
import com.capacitaciones.continuas.interfaces.ListCourseReduce;
import com.capacitaciones.continuas.services.CursoService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/curso")
public class CursoController extends GenericControllerImpl<Curso, Integer> {
    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService){
        this.cursoService = cursoService;
    }

    @Override
    protected GenericService<Curso, Integer> getService() {
        return cursoService;
    }

    @GetMapping("/cursoDisponibles/list")
    public ResponseEntity<List<Curso>> listCursoDisponibles(){
        try {
            return new ResponseEntity<>(cursoService.findByEstadoCursoAndEstadoPublicasionCurso(true), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cursosDelParticipante/list/{idParticipante}")
    public ResponseEntity<List<Curso>> listCursoDelParticipante(@PathVariable("idParticipante") Integer idParticipante){
        try {
            return new ResponseEntity<>(cursoService.findCursosDelParticipante(idParticipante), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyId/{id}")
    public ResponseEntity<?> getCursoById(@PathVariable("id") Integer id){
        try {
            Curso curso = cursoService.findById(id);
            if(curso != null){
                return new ResponseEntity<>(curso, HttpStatus.OK);
            }
            return new ResponseEntity<>("CURSO NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAllIdUsuario/{id}")
    public ResponseEntity<?> obtenerTodoslosCursosPorIdCapacitador(@PathVariable("id") Integer id){
        try {
            List<Curso> cursoList= cursoService.findByCapacitadorIdCapacitador(id);
            if(cursoList != null){
                return new ResponseEntity<>(cursoList, HttpStatus.OK);
            }
            return new ResponseEntity<>("MIS CURSOS NO ENCONTRADOS", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save1")
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso){
        try {
            //Aprovacion del curso // N = NO NO APROVADO, A = APROVADO, P = PENDIENTE
            curso.setEstadoAprovacionCurso("P");
            curso.setEstadoPublicasionCurso("O");
            curso.setEstadoCurso(true);
            //curso.setIniciocurso(false);
            return new ResponseEntity<>(cursoService.save(curso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update1/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        try {
            if (cursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            curso.setNombreCurso(curso.getNombreCurso());
            curso.setFotoCurso(curso.getFotoCurso());
            curso.setDuracionCurso(curso.getDuracionCurso());
            curso.setObservacionCurso(curso.getObservacionCurso());
            curso.setEstadoCurso(curso.getEstadoCurso());
            curso.setEstadoAprovacionCurso(curso.getEstadoAprovacionCurso());
            curso.setEstadoPublicasionCurso(curso.getEstadoPublicasionCurso());
            curso.setDescripcionCurso(curso.getDescripcionCurso());
            curso.setObjetivoGeneralesCurso(curso.getObjetivoGeneralesCurso());
            curso.setNumeroCuposCurso(curso.getNumeroCuposCurso());
            curso.setProgramas(curso.getProgramas());
            curso.setEspecialidad(curso.getEspecialidad());
            curso.setCapacitador(curso.getCapacitador());
            curso.setModalidadCurso(curso.getModalidadCurso());
            curso.setTipoCurso(curso.getTipoCurso());
            curso.setNivelCurso(curso.getNivelCurso());
            curso.setHorarioCurso(curso.getHorarioCurso());
            curso.setCursoocc(curso.getCursoocc());
            //curso.setIniciocurso(curso.getIniciocurso());

            Curso c = cursoService.save(curso);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //NEW METHODS---------------------------------------------------------

    @GetMapping("/findAll/course/finally")
    public ResponseEntity<?> findByAllCurseFinally(){
        try {
            List<CoursesFilter> cursoList= cursoService.findFilterCoursesD();
            if(cursoList != null){
                return new ResponseEntity<>(cursoList, HttpStatus.OK);
            }
            return new ResponseEntity<>("CURSOS NO ENCONTRADOS", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findFilterCoursesByUsuarioDocente/{id}")
    public ResponseEntity<List<CoursesFilterByDocente>> findFilterCoursesByUsuarioDocente(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(cursoService.findFilterCoursesByUsuarioDocente(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByIdUsuarioEstadoCursoFinalizado/{id}")
    public ResponseEntity<List<CoursesFilterByDocente>> findByIdUsuarioEstadoCursoFinalizado(@PathVariable("id") Integer id ){
        try {
            return new ResponseEntity<>(cursoService.findByIdUsuarioEstadoCursoFinalizado(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByCapacitadorUsuarioIdUsuarioPageable/{idUser}")
    public ResponseEntity<Page<?>> findByCapacitadorUsuarioIdUsuarioPageable(@PathVariable("idUser") Integer idUser, @PageableDefault(page = 0, size = 5, direction = Sort.Direction.ASC) Pageable pageable ){
        try {
            return new ResponseEntity<>(cursoService.findByCapacitadorUsuarioIdUsuarioPageable(idUser, pageable), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //NEW -------------------------------------------------------------------------------------------

    @GetMapping("/findByAllCourseDataReducePageable")
    public ResponseEntity<Page<ListCourseReduce>> findByAllCourseDataReducePageable(@PageableDefault(page = 0, size = 5, direction = Sort.Direction.DESC) Pageable pageable ){
        try {
            return new ResponseEntity<>(cursoService.findByAllCourseDataReducePageable(pageable), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/updateStatusCourseAcepted/{idCourse}/{status}")
    public ResponseEntity<Map<String, Integer>> updateStatusCourseAcepted(@PathVariable("idCourse") Integer idCourse, @PathVariable("status") String status) {
        try {
            Map<String, Integer> response = new HashMap<>();
            response.put("idCurso", idCourse);
            Integer result = cursoService.updateStatusCourseAcepted(idCourse, status);
            return (result == 1) ? new ResponseEntity<>(response, HttpStatus.OK) :  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/normal")
    public List<Curso> getAll() {
        return cursoService.findByAll();
    }
    @GetMapping("/async")
    public CompletableFuture<List<Curso>> getAllCoursesAsync() {
        return cursoService.findByAllAsync();
    }
}
