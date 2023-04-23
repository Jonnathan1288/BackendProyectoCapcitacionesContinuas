package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.Rol;
import com.capacitaciones.continuas.repositorys.RolRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Integer> implements RolService {

    @Autowired
    RolRespository rolRespository;

    @Override
    public CrudRepository<Rol, Integer> getDao() {
        return rolRespository;
    }
}
