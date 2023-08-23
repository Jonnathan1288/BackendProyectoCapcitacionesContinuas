package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.DisenioCurricular;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface DisenioCurricularService extends GenericService<DisenioCurricular, Integer> {
    Boolean findBySilaboIdSilabo(Integer idSilabo);


    DisenioCurricular DisenioCurricularfindBySilaboIdSilabo(Integer idSilabo);


    public DisenioCurricular findBySilaboCursoIdCurso(Integer idCurso);
}
