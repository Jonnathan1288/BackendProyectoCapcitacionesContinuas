package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;

public interface HojaVidaCapacitadorService extends GenericService<HojaVidaCapacitador, Integer>{
    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitador_IdCapacitador(Integer idCapacitador);

    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(Integer iDUsuario);

}
