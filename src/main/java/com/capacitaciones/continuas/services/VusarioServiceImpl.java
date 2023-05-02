package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.vusuario;
import com.capacitaciones.continuas.repositorys.Secondary.VusuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VusarioServiceImpl extends GenericServiceImpl<vusuario, Integer> implements VusarioService {

    @Autowired
    private VusuarioRepository vusuarioRepository;

    @Override
    public CrudRepository<vusuario, Integer> getDao() {
        return vusuarioRepository;
    }
}

