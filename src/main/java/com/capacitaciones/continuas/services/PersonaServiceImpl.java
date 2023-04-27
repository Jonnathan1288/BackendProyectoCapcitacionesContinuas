package com.capacitaciones.continuas.services;


import models.Persona;
import com.capacitaciones.continuas.repositorys.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return personaRepository;
    }
}
