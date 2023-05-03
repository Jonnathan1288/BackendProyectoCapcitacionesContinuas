package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.repositorys.Primarys.HojaVidaCapacitadorRespository;
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
    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitador_IdCapacitador(Integer idCapacitador) {
        return hojaVidaCapacitadorRespository.findHojaVidaCapacitadorByCapacitador_IdCapacitador(idCapacitador);
    }

    @Override
    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(Integer iDUsuario) {
        return hojaVidaCapacitadorRespository.findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(iDUsuario);
    }
}
