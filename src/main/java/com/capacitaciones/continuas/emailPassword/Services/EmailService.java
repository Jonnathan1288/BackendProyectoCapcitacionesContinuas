package com.capacitaciones.continuas.emailPassword.Services;

import com.capacitaciones.continuas.Dtos.EmailCourseApprovedDto;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.Modelos.Primary.DocumentoSenecyt;
import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.emailPassword.Dtos.EmailValuesDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface EmailService {

    boolean sendEmail(EmailValuesDTO values);

    public boolean sendEmailEstudiantesMatriculadosNoMatriculados(Integer idCurso, String sendFrom);

    public boolean sendEmailCodigosSenecyt(Usuario user, DocumentoSenecyt senecyt, String sendFrom);

    public boolean sendEmailCpurseApprovedAdmin(EmailCourseApprovedDto courseApprovedDto);

    public CompletableFuture<Boolean> sendEmailCpurseApprovedAdminAsync(EmailCourseApprovedDto courseApprovedDto);

}
