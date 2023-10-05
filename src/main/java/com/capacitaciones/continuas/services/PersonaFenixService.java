package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import com.capacitaciones.continuas.Modelos.Secondary.PersonaFenix;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaFenixService {

    public List<PersonaFenix> findAll();

    public PersonaFenix findByIdentificacion(String ci);

}
