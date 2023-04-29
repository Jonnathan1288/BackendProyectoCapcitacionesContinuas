package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.Inscrito;
import com.capacitaciones.continuas.repositorys.InscritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscritoServiceImpl extends GenericServiceImpl<Inscrito, Integer> implements InscritoService {

    @Autowired
    InscritoRepository matriculaRepository;

    @Override
    public CrudRepository<Inscrito, Integer> getDao() {
        return matriculaRepository;
    }

    @Override
    public List<Inscrito> findByCursoIdCurso(Integer idCurso) {
        return matriculaRepository.findByCursoIdCurso(idCurso);
    }
}
