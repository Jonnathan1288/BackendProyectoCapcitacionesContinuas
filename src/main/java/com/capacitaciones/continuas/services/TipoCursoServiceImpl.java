package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.Silabo;
import com.capacitaciones.continuas.models.TipoCurso;
import com.capacitaciones.continuas.repositorys.SilaboRepository;
import com.capacitaciones.continuas.repositorys.TipoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoCursoServiceImpl extends GenericServiceImpl<TipoCurso, Integer> implements TipoCursoService {

    @Autowired
    private TipoCursoRepository tipoCursoRepository;

    @Override
    public CrudRepository<TipoCurso, Integer> getDao() {
        return tipoCursoRepository;
    }
}
