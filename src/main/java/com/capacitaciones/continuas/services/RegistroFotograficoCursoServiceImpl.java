package com.capacitaciones.continuas.services;


import models.RegistroFotograficoCurso;
import com.capacitaciones.continuas.repositorys.RegistroFotograficoCurosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroFotograficoCursoServiceImpl extends GenericServiceImpl<RegistroFotograficoCurso, Integer> implements RegistroFotograficoCursoService {

    @Autowired
    RegistroFotograficoCurosRepository registroFotograficoCurosRepository;

    @Override
    public CrudRepository<RegistroFotograficoCurso, Integer> getDao() {
        return registroFotograficoCurosRepository;
    }
}