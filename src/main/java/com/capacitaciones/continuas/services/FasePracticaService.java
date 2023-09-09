package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface FasePracticaService extends GenericService<FasePractica, Integer> {

    public List<FasePractica> findAllByDisenioCurricularId(Integer disenioCurricularId);
}
