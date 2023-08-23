package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.InformeFinalCurso;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface InformeFinalCursoService  extends GenericService<InformeFinalCurso, Integer> {
    public InformeFinalCurso findByCursoIdCurso(Integer idCurso);
}
