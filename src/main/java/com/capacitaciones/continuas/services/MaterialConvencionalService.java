package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.MaterialConvencional;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface MaterialConvencionalService extends GenericService<MaterialConvencional, Integer> {

    List<MaterialConvencional> findBySilaboIdSilabo(Integer idSilabo);
}
