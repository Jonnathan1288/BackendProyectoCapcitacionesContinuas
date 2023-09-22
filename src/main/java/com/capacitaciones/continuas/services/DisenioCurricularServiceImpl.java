package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.DisenioCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.DisenioCurricularRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DisenioCurricularServiceImpl extends GenericServiceImplv2<DisenioCurricular, Integer> implements DisenioCurricularService{
    @Autowired
    private DisenioCurricularRepository disenioCurricularRepository;
    @Override
    public GenericRepository<DisenioCurricular, Integer> getDao() {
        return disenioCurricularRepository;
    }

    @Override
    public Boolean findBySilaboIdSilabo(Integer idSilabo) {
        if (disenioCurricularRepository.findBySilaboIdSilabo(idSilabo)!=null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public DisenioCurricular DisenioCurricularfindBySilaboIdSilabo(Integer idSilabo) {
        return disenioCurricularRepository.findBySilaboIdSilabo(idSilabo);
    }

    @Override
    public DisenioCurricular findBySilaboCursoIdCurso(Integer idCurso) {
        return disenioCurricularRepository.findBySilaboCursoIdCurso(idCurso);
    }
}
