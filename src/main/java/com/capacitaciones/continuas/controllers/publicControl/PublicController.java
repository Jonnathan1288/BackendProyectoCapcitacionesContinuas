package com.capacitaciones.continuas.controllers.publicControl;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
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

}
