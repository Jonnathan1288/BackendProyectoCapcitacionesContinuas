package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Persona;

public interface EmailService {

    boolean sendEmail(Persona p);

}
