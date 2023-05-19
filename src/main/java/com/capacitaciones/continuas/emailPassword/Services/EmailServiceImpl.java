package com.capacitaciones.continuas.emailPassword.Services;

import com.capacitaciones.continuas.emailPassword.Dtos.EmailValuesDTO;
import com.capacitaciones.continuas.repositorys.Primarys.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    ITemplateEngine ITemplateEngine;

    @Autowired
    private PersonaRepository personarepository;

    @Value("${mail.urlFront}")
    private String urlFront;

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
}
