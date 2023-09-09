package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface FaseTeoricaService extends GenericService<FaseTeorica, Integer> {

    public List<FaseTeorica> findAllByDisenioCurricularId(Integer disenioCurricularId);
}
