package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.Matricula;
import com.capacitaciones.continuas.repositorys.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImpl extends GenericServiceImpl<Matricula, Integer> implements MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Override
    public CrudRepository<Matricula, Integer> getDao() {
        return matriculaRepository;
    }

}
