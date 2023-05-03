package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
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


    public HojaVidaCapacitador guardarCV(byte[] documento, Capacitador capacitador) {
        HojaVidaCapacitador cv = new HojaVidaCapacitador();
        cv.setCapacitador(capacitador);
        cv.setDocumento(documento);
        cv.setEstadoAprobacion("P");
        return hojaVidaCapacitadorRespository.save(cv);
    }

    @Override
    public boolean findByCapacitadorUsuarioIdUsuario(Integer idUsuario) {
        if (hojaVidaCapacitadorRespository.findByCapacitadorUsuarioIdUsuario(idUsuario) == null) {
            return false;
        } else {
            return true;
        }
    }
}
