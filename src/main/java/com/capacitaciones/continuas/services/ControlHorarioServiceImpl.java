package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.ContenidoSilabo;
import com.capacitaciones.continuas.models.ControlHorario;
import com.capacitaciones.continuas.repositorys.ContenidoSilaboRepository;
import com.capacitaciones.continuas.repositorys.ControlHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ControlHorarioServiceImpl extends GenericServiceImpl<ControlHorario, Integer> implements ControlHorarioService{
    @Autowired
    private ControlHorarioRepository controlHorarioRepository;
    @Override
    public CrudRepository<ControlHorario, Integer> getDao() {
        return controlHorarioRepository;
    }
}
