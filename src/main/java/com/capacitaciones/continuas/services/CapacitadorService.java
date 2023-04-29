package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.Capacitador;

public interface CapacitadorService extends  GenericService<Capacitador, Integer>{
    public Capacitador findByUsuarioIdUsuario(Integer idUsuario);
}
