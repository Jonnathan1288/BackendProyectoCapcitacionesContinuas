package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EstrategiasMetodologica;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface EstrategiaMetodologicaService extends GenericService<EstrategiasMetodologica, Integer> {

    List<EstrategiasMetodologica> findBySilaboIdSilabo(Integer idSilabo);
}
