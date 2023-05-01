package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.ContenidoSilabo;
import com.capacitaciones.continuas.models.EntornoAprendizajeCurricular;

import java.util.List;

public interface EntornoAprendizajeCurricularService extends  GenericService<EntornoAprendizajeCurricular, Integer>{
    List<EntornoAprendizajeCurricular> findByDisenioCurricularbyDisenio(Integer idDisenioCurricular);
}




