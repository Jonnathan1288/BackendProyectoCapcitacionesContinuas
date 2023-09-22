package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Especialidad;
import com.capacitaciones.continuas.repositorys.Primarys.EspecialidadRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl extends GenericServiceImplv2<Especialidad, Integer> implements EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Override
    public GenericRepository<Especialidad, Integer> getDao() {
        return especialidadRepository;
    }

    @Override
    public List<Especialidad> findByAreaIdArea(Integer idArea) {
        return especialidadRepository.findByAreaIdArea(idArea);
    }
}
