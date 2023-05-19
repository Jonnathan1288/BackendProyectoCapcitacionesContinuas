package com.capacitaciones.continuas.emailPassword.Services;

import com.capacitaciones.continuas.emailPassword.Dtos.EmailValuesDTO;

public interface EmailService {

    boolean sendEmail(EmailValuesDTO values);

}
