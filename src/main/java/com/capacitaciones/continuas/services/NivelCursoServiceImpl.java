package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.NivelCurso;
import com.capacitaciones.continuas.repositorys.Primarys.NivelCursoRepositry;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class NivelCursoServiceImpl extends GenericServiceImplv2<NivelCurso, Integer> implements NivelCursoService {

    @Autowired
    private NivelCursoRepositry nivelCursoRepositry;

    @Override
    public GenericRepository<NivelCurso, Integer> getDao() {
        return nivelCursoRepositry;
    }
}