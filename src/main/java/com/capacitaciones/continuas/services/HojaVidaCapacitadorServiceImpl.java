package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.interfaces.HojaVida;
import com.capacitaciones.continuas.repositorys.Primarys.HojaVidaCapacitadorRespository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class HojaVidaCapacitadorServiceImpl extends GenericServiceImpl<HojaVidaCapacitador, Integer> implements HojaVidaCapacitadorService {

    @Autowired
    HojaVidaCapacitadorRespository hojaVidaCapacitadorRespository;

    @Override
    public CrudRepository<HojaVidaCapacitador, Integer> getDao() {
        return hojaVidaCapacitadorRespository;
    }


    @Override
    public boolean findByCapacitadorUsuarioIdUsuario(Integer idUsuario) {
        if (hojaVidaCapacitadorRespository.findByCapacitadorUsuarioIdUsuario(idUsuario) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public HojaVida findHojaVidaByIdUsuario(Integer id) {
        return hojaVidaCapacitadorRespository.findHojaVidaByIdUsuario(id);
    }
}
