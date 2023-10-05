package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.EstudianteFenix;
import com.capacitaciones.continuas.Modelos.Secondary.PersonaFenix;
import com.capacitaciones.continuas.repositorys.Secondary.EstudianteFenixRepository;
import com.capacitaciones.continuas.repositorys.Secondary.PersonaFenixRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaFenixServiceImpl  implements PersonaFenixService {
    private PersonaFenixRepository personaFenixRepository;

    @Autowired
    public PersonaFenixServiceImpl(PersonaFenixRepository personaFenixRepository){
        this.personaFenixRepository = personaFenixRepository;
    }

    @Override
    public List<PersonaFenix> findAll() {
        return personaFenixRepository.findAll();
    }

    @Override
    public PersonaFenix findByIdentificacion(String ci) {
        return personaFenixRepository.findByIdentificacion(ci);
    }
}

