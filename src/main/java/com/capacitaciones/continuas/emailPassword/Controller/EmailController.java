package com.capacitaciones.continuas.emailPassword.Controller;

import com.capacitaciones.continuas.Modelos.Primary.DocumentoSenecyt;
import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.emailPassword.Dtos.CambiarPasswordDTO;
import com.capacitaciones.continuas.emailPassword.Dtos.EmailValuesDTO;
import com.capacitaciones.continuas.emailPassword.Services.EmailServiceImpl;
import com.capacitaciones.continuas.repositorys.Primarys.UsuarioRepository;
import com.capacitaciones.continuas.services.DocumentoSenecytService;
import com.capacitaciones.continuas.services.PersonaService;
import com.capacitaciones.continuas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private PersonaService personaservice;

    @Autowired
    private UsuarioService usuarioService;

    @Value("${spring.mail.username}")
    private String sendFrom;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DocumentoSenecytService documentoSenecytService;

      @GetMapping("/email/sendRecuperacionPassword/{identificacion}")
    public ResponseEntity<?> sendEmailRecuperacion(@PathVariable("identificacion") String identificacion){

        try {
            Usuario usuario = usuarioService.findByPersonaIdentificacion(identificacion);
            if (usuario == null) {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND_USUARIO");
            }
            EmailValuesDTO values = new EmailValuesDTO();
            values.setMailFrom(sendFrom);
            values.setMailTo(usuario.getPersona().getCorreo());
            values.setUsername(usuario.getPersona().getNombre1() + ' ' + usuario.getPersona().getNombre2() + ' ' + usuario.getPersona().getApellido1() + ' ' + usuario.getPersona().getApellido2());
            values.setSubject("RESTAURAR CONSTRASEÑA");
            UUID uuid = UUID.randomUUID();
            String tokenPassword  = uuid.toString();
            values.setJwt(tokenPassword);
            usuario.setTokenPassword(tokenPassword);
            if(usuario != null) {
                if(emailService.sendEmail(values) == true) {
                    return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
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

    @PostMapping("/cambiarContraseniaUsuario")
    public ResponseEntity<?> cambiarContraseniaUsuario(@Valid @RequestBody CambiarPasswordDTO dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Campos mal puestos", HttpStatus.BAD_REQUEST);
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            return new ResponseEntity<>("No coinciden", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = usuarioService.findByTokenPassword(dto.getTokenPassword());
        if (usuario == null) {
            return new ResponseEntity<>("No encontrado el usuario", HttpStatus.BAD_REQUEST);
        }
        String passwordNew = passwordEncoder.encode(dto.getPassword());
        usuario.setPassword(passwordNew);
        usuario.setTokenPassword(null);
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.OK);
    }

    @GetMapping("/email/sendEmailEstudentMatriculadoNoMatriculado/{idCurso}")
    public ResponseEntity<?> sendEmailEstudentMatriculadoNoMatriculado(@PathVariable("idCurso") Integer idCurso){
        try {
            if(emailService.sendEmailEstudiantesMatriculadosNoMatriculados(idCurso, sendFrom)){
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            System.out.println("Email err-> "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/email/sendEmailDocumentoSenescyt/{idUsuario}/{idDocumentSenecyt}")
    public ResponseEntity<?> sendEmailDocumentoSenescyt(@PathVariable("idUsuario") Integer idUsuario, @PathVariable("idDocumentSenecyt") Integer idDocumentSenecyt){
        try {
            Usuario usuario = usuarioService.findById(idUsuario);
            DocumentoSenecyt documentoSenecyt = documentoSenecytService.findById(idDocumentSenecyt);

            if(usuario != null && documentoSenecyt != null){
                if(emailService.sendEmailCodigosSenecyt(usuario, documentoSenecyt, sendFrom)){
                    return new ResponseEntity<>(documentoSenecyt, HttpStatus.OK);
                }else{
                    System.out.println("Error");
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }else{
                System.out.println("NO ENCONTRADO");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            System.out.println("Email err-> "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







    /*public ResponseEntity<?> sendEmailEstudentMatriculadoNoMatriculado(@PathVariable("idCurso") Integer idCurso){
        try {
            List<Inscrito> inscritoList = inscritoService.findByCursoIdCurso(idCurso);
            if(inscritoList != null){
                inscritoList.stream().forEach(inscrito ->{
                    emailService.sendEmailEstudiantesMatriculadosNoMatriculados(idCurso, sendFrom);
                });
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            System.out.println("Email err-> "+e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

}
