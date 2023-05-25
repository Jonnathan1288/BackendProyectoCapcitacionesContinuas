package com.capacitaciones.continuas.controllers.publicControl;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.Modelos.Primary.ParticipantesAprobados;
import com.capacitaciones.continuas.Modelos.Primary.Rol;
import com.capacitaciones.continuas.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class PublicController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private RolService rolService;

    @Autowired
    private JasperReportService jasperReportService;

    @Autowired
    private ParticipantesAprobadosService participantesAprobadosService;

    @Autowired
    private HojaVidaCapacitadorService hojaVidaCapacitadorService;


    @Autowired
    private CapacitadorService capacitadorService;


    @GetMapping("/usuario/existsbyUsername/{username}")
    public Boolean existsbyexistsbyUsername(@PathVariable("username") String username){
        try {
            if(usuarioService.existsByUsername(username)){
                return true;
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @GetMapping("/persona/existsbyIdentifcasion/{identificasion}")
    public Boolean existsbyIdentifcasion(@PathVariable("identificasion") String identificasion){
        try {
            if(personaService.existsByIdentificacion(identificasion)){
                return true;
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    //PARA LAS PARTES PUEBLICAS
    @GetMapping("/persona/existsByPersonaCorreo/{email}")
    public Boolean existsByPersonaCorreo(@PathVariable("email") String email){
        try {
            if(usuarioService.existsByPersonaCorreo(email)){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("existsByPersonaCorreo err-> "+e.getMessage());
            return null;
        }
    }

    @GetMapping("/rol/findbyId/{id}")
    public ResponseEntity<?> getRolById(@PathVariable("id") Integer id){
        try {
            Rol nc = rolService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("ROL NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/generarCertificadoEstudiante/download/{idCurso}/{identificasion}")
    public void generarCodigosAsignarSenecyt(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso, @PathVariable("identificasion") String identificasion) throws Exception {
        try {
            jasperReportService.generateCertificadoEstudiante(response, idCurso, identificasion);

        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/participantesAprobados/findbyIdIdCursoAndUsuario/{idCurso}/{ci}")
    public ResponseEntity<?> participantesAprobadosFindbyIdIdCursoAndUsuario(@PathVariable("idCurso") Integer idCurso, @PathVariable("ci") String ci){
        try {
            ParticipantesAprobados certificate = participantesAprobadosService.findByCursoAndUsuario(idCurso, ci);
            if(certificate != null){
                return new ResponseEntity<>(certificate, HttpStatus.OK);
            }
            return new ResponseEntity<>("CERTIFICADO NOT FOUND",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/hojaVida/updateDocumento/{idUsuario}")
    public ResponseEntity<?> updateCVDocumento(@RequestParam("file") MultipartFile file, @PathVariable("idUsuario") Integer idUsuario) throws IOException {
        HojaVidaCapacitador hojaVidaCapacitador = hojaVidaCapacitadorService.findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(idUsuario);
        if(hojaVidaCapacitador == null){
            return ResponseEntity.badRequest().body("No se encontro CAPACITADOR.");
        }
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ningún archivo.");
        }
        byte[] bytesDocumento = file.getBytes();
        return new ResponseEntity<>(hojaVidaCapacitadorService.updateCVCapacitador(bytesDocumento,hojaVidaCapacitador), HttpStatus.CREATED);
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
}
