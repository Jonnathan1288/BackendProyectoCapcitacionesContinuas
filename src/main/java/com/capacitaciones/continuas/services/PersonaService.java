package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Persona;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface PersonaService extends GenericService<Persona, Integer> {
    public Boolean existsByIdentificacion(String identificasion);

}
