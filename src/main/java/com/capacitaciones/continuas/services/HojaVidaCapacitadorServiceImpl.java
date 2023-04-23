package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.HojaVidaCapacitador;
import com.capacitaciones.continuas.repositorys.HojaVidaCapacitadorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class HojaVidaCapacitadorServiceImpl extends GenericServiceImpl<HojaVidaCapacitador, Integer> implements HojaVidaCapacitadorService {

    @Autowired
    HojaVidaCapacitadorRespository hojaVidaCapacitadorRespository;

    @Override
    public CrudRepository<HojaVidaCapacitador, Integer> getDao() {
        return hojaVidaCapacitadorRespository;
    }

}
