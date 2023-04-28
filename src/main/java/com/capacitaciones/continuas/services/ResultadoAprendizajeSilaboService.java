package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.ResultadoAprendizajeSilabo;

import java.util.List;

public interface ResultadoAprendizajeSilaboService extends GenericService<ResultadoAprendizajeSilabo,Integer>{

    List<ResultadoAprendizajeSilabo> findBySilaboIdSilabo(Integer idSilabo);

}

