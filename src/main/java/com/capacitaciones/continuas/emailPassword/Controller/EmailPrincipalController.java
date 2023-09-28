package com.capacitaciones.continuas.emailPassword.Controller;


import com.capacitaciones.continuas.Dtos.EmailCourseApprovedDto;
import com.capacitaciones.continuas.emailPassword.Services.EmailServiceImpl;
import com.capacitaciones.continuas.repositorys.Primarys.UsuarioRepository;
import com.capacitaciones.continuas.services.DocumentoSenecytService;
import com.capacitaciones.continuas.services.PersonaService;
import com.capacitaciones.continuas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmailPrincipalController {
    private EmailServiceImpl emailService;

    public EmailPrincipalController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email/sendEmailDocumentoSenescyt")
    public Boolean sendEmailAprprovedCourse(@RequestBody EmailCourseApprovedDto dto) {
        return emailService.sendEmailCpurseApprovedAdmin(dto);
    }
}
