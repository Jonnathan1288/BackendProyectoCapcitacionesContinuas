package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface ParroquiaService extends GenericService<Parroquia, Integer> {
    public List<Parroquia> findByCanton_IdCanton(Integer idCanton);
}
