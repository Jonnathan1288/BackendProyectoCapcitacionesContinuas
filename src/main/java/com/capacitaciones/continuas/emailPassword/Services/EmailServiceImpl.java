package com.capacitaciones.continuas.emailPassword.Services;

import com.capacitaciones.continuas.Dtos.EmailCourseApprovedDto;
import com.capacitaciones.continuas.Modelos.Primary.DocumentoSenecyt;
import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.emailPassword.Dtos.EmailValuesDTO;
import com.capacitaciones.continuas.repositorys.Primarys.InscritoRepository;
import com.capacitaciones.continuas.repositorys.Primarys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
public class EmailServiceImpl implements EmailService {
    private JavaMailSender javaMailSender;
    private ITemplateEngine ITemplateEngine;
    private UsuarioRepository usuarioRepository;
    private InscritoRepository inscritoRepository;

    @Value("${mail.urlFront}")
    private String urlFront;

    @Value("${spring.mail.username}")
    private String sendFrom;

    public EmailServiceImpl(JavaMailSender javaMailSender, ITemplateEngine ITemplateEngine, UsuarioRepository usuarioRepository, InscritoRepository inscritoRepository){
        this.javaMailSender = javaMailSender;
        this.ITemplateEngine = ITemplateEngine;
        this.usuarioRepository = usuarioRepository;
        this.inscritoRepository = inscritoRepository;
    }

    @Override
    public boolean sendEmail(EmailValuesDTO values) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("username", values.getUsername());
            model.put("url", urlFront + values.getJwt());
            context.setVariables(model);
            String htmlText = ITemplateEngine.process("email_template",context);
            helper.setFrom(values.getMailFrom());
            helper.setTo(values.getMailTo());
            helper.setSubject(values.getSubject());
            helper.setText(htmlText,true);
            javaMailSender.send(message);
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean sendEmailEstudiantesMatriculadosNoMatriculados(Integer idCurso,String sendFrom) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            List<Inscrito> inscritoList = inscritoRepository.findByCursoIdCurso(idCurso);

            inscritoList.stream().forEach(inscrito -> {
                String estdoaprovacion = "";
                if (inscrito.getEstadoInscrito()) {
                    estdoaprovacion = "¡Curso Aceptado!";
                } else {
                    estdoaprovacion = "¡Curso no Aceptado!";
                }
                MimeMessageHelper helper = null;
                try {
                    helper = new MimeMessageHelper(message, true);
                    Context context = new Context();
                    Map<String, Object> model = new HashMap<>();
                    model.put("estado", estdoaprovacion);
                    model.put("status", inscrito.getEstadoInscrito());
                    model.put("nombreCurso", inscrito.getCurso().getNombreCurso());

                    //Fecha formateada..
                    // Obtén la fecha de inicio del curso en formato LocalDate
                    LocalDate fechaInicio = inscrito.getCurso().getFechaInicioCurso();
                    // Crea el formateador de fecha
                    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("es"));
                    // Formatea la fecha en el formato deseado
                    String fechaFormateada = fechaInicio.format(formateador);

                    model.put("fechaInicio", fechaFormateada);
                    model.put("duracio", inscrito.getCurso().getDuracionCurso() + " horas");
                    model.put("Docente", inscrito.getCurso().getCapacitador().getTipoAbreviaturaTitulo() + " " + inscrito.getCurso().getCapacitador().getUsuario().getPersona().getNombre1() + " " + inscrito.getCurso().getCapacitador().getUsuario().getPersona().getApellido1());
                    context.setVariables(model);
                    String htmlText = ITemplateEngine.process("acept", context);
                    helper.setFrom(sendFrom);
                    helper.setTo(inscrito.getUsuario().getPersona().getCorreo());
                    helper.setSubject("CURSOS DE CAPACITACIÓN CONTINUA.");
                    helper.setText(htmlText, true);
                    javaMailSender.send(message);
                }catch (MessagingException e) {
                    System.out.println(e.getMessage());
                }
            });


            return true;
        }catch (Exception e){
            System.out.println("Errro en la parte del server-> "+e.getMessage());
            return false;
        }

    }

    @Override
    public boolean sendEmailCodigosSenecyt(Usuario user, DocumentoSenecyt senecyt, String sendFrom) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            String contenidoBase64 = senecyt.getDocumentoExel();
            String base64 = contenidoBase64.substring(contenidoBase64.indexOf(',') + 1);

            byte[] excelBytes = Base64.getDecoder().decode(base64);

            // Obtén la fecha de inicio del curso en formato LocalDate
            LocalDate now = LocalDate.now();
            // Crea el formateador de fecha
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("es"));
            // Formatea la fecha en el formato deseado
            String fechaFormateada = now.format(formateador);

            model.put("fechaEmision", fechaFormateada);
            context.setVariables(model);
            String htmlText = ITemplateEngine.process("codigos",context);
            helper.setFrom(sendFrom);
            helper.setTo(user.getPersona().getCorreo());
            helper.setSubject("CAPACITACIÓN CONTINUA.");
            helper.setText(htmlText,true);
            //helper.addInline("excel", new ByteArrayResource(excelBytes), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            helper.addAttachment("codigosSenescyt"+now+".xlsx", new ByteArrayResource(excelBytes), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

            javaMailSender.send(message);
            return true;

        } catch (Exception e) {
            System.out.println("Nuev_> "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean sendEmailCpurseApprovedAdmin(EmailCourseApprovedDto courseApprovedDto) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                Context context = new Context();

                Map<String, Object> model = new HashMap<>();
                model.put("sumary", courseApprovedDto.getSumary());
                model.put("status", courseApprovedDto.getStatus());
                model.put("course", courseApprovedDto.getNameCourse());
                context.setVariables(model);

                String htmlText = ITemplateEngine.process("course_approved_admin", context);
                helper.setFrom(sendFrom);
                helper.setTo(courseApprovedDto.getReceptor());
                helper.setSubject(courseApprovedDto.getTopic());
                helper.setText(htmlText, true);
                javaMailSender.send(message);
            return true;
        }catch (Exception e){
            System.out.println("Errro en la parte del server-> "+e.getMessage());
            return false;
        }
    }
}
