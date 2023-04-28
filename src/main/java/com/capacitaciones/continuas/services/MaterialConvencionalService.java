package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.MaterialConvencional;

import java.util.List;

public interface MaterialConvencionalService extends  GenericService<MaterialConvencional, Integer>{

    List<MaterialConvencional> findBySilaboIdSilabo(Integer idSilabo);
}
