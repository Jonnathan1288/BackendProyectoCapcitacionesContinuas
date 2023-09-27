package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.interfaces.HojaVida;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.web.bind.annotation.RequestParam;

public interface HojaVidaCapacitadorService extends GenericService<HojaVidaCapacitador, Integer> {
    public boolean findByCapacitadorUsuarioIdUsuario(Integer idUsuario);

    public HojaVida findHojaVidaByIdUsuario(Integer id);
}
