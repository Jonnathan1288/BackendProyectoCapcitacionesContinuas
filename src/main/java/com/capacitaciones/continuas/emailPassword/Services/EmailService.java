package com.capacitaciones.continuas.emailPassword.Services;

import com.capacitaciones.continuas.Dtos.EmailCourseApprovedDto;
import com.capacitaciones.continuas.Modelos.Primary.DocumentoSenecyt;
import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.emailPassword.Dtos.EmailValuesDTO;

public interface EmailService {

    boolean sendEmail(EmailValuesDTO values);

    public boolean sendEmailEstudiantesMatriculadosNoMatriculados(Integer idCurso, String sendFrom);

    public boolean sendEmailCodigosSenecyt(Usuario user, DocumentoSenecyt senecyt, String sendFrom);

    public boolean sendEmailCpurseApprovedAdmin(EmailCourseApprovedDto courseApprovedDto, String sendFrom);

}
