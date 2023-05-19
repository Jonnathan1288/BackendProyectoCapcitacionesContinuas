package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Persona;
import com.capacitaciones.continuas.repositorys.Primarys.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    ITemplateEngine ITemplateEngine;

    @Autowired
    private PersonaRepository personarepository;

    @Value("${spring.mail.username}")
    private String EMAIL_SEND;

    @Override
    public boolean sendEmail(Persona p) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            String htmlText = ITemplateEngine.process("email_template",context);
            helper.setFrom(EMAIL_SEND);
            helper.setTo(p.getCorreo());
            helper.setSubject("Prueba envio email simple");
            helper.setText(htmlText,true);
            javaMailSender.send(message);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
