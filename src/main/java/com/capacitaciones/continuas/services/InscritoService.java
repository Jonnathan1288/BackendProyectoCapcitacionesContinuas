package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface InscritoService extends GenericService<Inscrito, Integer> {
    List<Inscrito> findByCursoIdCurso(Integer idCurso);

    boolean findByCursoIdCursoAndUsuarioIdUsuario(Integer idCurso, Integer idUsuario);

    Inscrito findByUsuarioIdUsuario(Integer idCurso, Integer idUsuario);


}
