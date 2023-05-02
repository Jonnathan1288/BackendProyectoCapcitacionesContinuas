package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.DetalleFichaMatricula;

public interface DetalleFichaService extends  GenericService<DetalleFichaMatricula, Integer>{

    public DetalleFichaMatricula findByFichaMatriculaInscritoUsuario(Integer idUsuario);

}
