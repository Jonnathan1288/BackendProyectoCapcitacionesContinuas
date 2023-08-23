package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.NecesidadCurso;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface NecesidadCursoService extends GenericService<NecesidadCurso, Integer> {
    public NecesidadCurso findByCursoIdCurso(Integer idCurso);
}
