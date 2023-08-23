package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ResultadoAprendizajeSilabo;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface ResultadoAprendizajeSilaboService extends GenericService<ResultadoAprendizajeSilabo,Integer> {

    List<ResultadoAprendizajeSilabo> findBySilaboIdSilabo(Integer idSilabo);

}

