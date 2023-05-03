package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;

public interface HojaVidaCapacitadorService extends GenericService<HojaVidaCapacitador, Integer>{

    public HojaVidaCapacitador guardarCV(byte[] documento, Capacitador capacitador);

    public boolean findByCapacitadorUsuarioIdUsuario(Integer idUsuario);

}
