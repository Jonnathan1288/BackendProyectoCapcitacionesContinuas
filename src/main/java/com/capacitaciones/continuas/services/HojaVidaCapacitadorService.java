package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface HojaVidaCapacitadorService extends GenericService<HojaVidaCapacitador, Integer> {

    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitador_IdCapacitador(Integer idCapacitador);

    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(Integer iDUsuario);

    public HojaVidaCapacitador guardarCV(byte[] documento, Capacitador capacitador);

    public boolean findByCapacitadorUsuarioIdUsuario(Integer idUsuario);

    public HojaVidaCapacitador updateCVCapacitador(byte[] documento, HojaVidaCapacitador hojaVidaCapacitador);


}
