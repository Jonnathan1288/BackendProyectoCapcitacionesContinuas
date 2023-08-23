package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ContenidoSilabo;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface ContenidoSilaboService extends GenericService<ContenidoSilabo, Integer> {

    List<ContenidoSilabo> findBySilaboIdSilabo(Integer idSilabo);

}
