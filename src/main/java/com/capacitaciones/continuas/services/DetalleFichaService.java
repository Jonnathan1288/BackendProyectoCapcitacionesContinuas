package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.DetalleFichaMatricula;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface DetalleFichaService extends GenericService<DetalleFichaMatricula, Integer> {

    public DetalleFichaMatricula findByUsuarioIdUsuario(Integer idUsuario);

}
