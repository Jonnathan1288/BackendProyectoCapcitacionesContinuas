package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.repositorys.Primarys.CapacitadorRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CapacitadorServiceImpl extends GenericServiceImplv2<Capacitador, Integer> implements CapacitadorService{
    @Autowired
    private CapacitadorRepository capacitadorRepository;
    @Override
    public GenericRepository<Capacitador, Integer> getDao() {
        return capacitadorRepository;
    }

    @Override
    public Capacitador findByUsuarioIdUsuario(Integer idUsuario) {
        return capacitadorRepository.findByUsuarioIdUsuario(idUsuario);
    }

    @Override
    public Boolean existsByUsuarioIdUsuario(Integer idUsuario) {
        return capacitadorRepository.existsByUsuarioIdUsuario(idUsuario);
    }
}
