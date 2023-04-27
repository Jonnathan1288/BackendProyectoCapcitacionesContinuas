package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.Asistencia;
import com.capacitaciones.continuas.repositorys.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaServiceImpl extends GenericServiceImpl<Asistencia, Integer> implements AsistenciaService{
    @Autowired
    private AsistenciaRepository asistenciaRepository;
    @Override
    public CrudRepository<Asistencia, Integer> getDao() {
        return asistenciaRepository;
    }
}
