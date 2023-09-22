package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.DisenioCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisenioCurricularRepository extends GenericRepository<DisenioCurricular, Integer> {
    DisenioCurricular findBySilaboIdSilabo(Integer idSilabo);

    public DisenioCurricular findBySilaboCursoIdCurso(Integer idCurso);
}

