package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.Especialidad;
import com.capacitaciones.continuas.repositorys.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<Especialidad, Integer> implements EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;
    @Override
    public CrudRepository<Especialidad, Integer> getDao() {
        return especialidadRepository;
    }
}
