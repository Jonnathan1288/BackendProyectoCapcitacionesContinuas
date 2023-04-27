package com.capacitaciones.continuas.services;


import models.Silabo;
import com.capacitaciones.continuas.repositorys.SilaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SilaboServiceImpl extends GenericServiceImpl<Silabo, Integer> implements SilaboService {

    @Autowired
    SilaboRepository silaboRepository;

    @Override
    public CrudRepository<Silabo, Integer> getDao() {
        return silaboRepository;
    }
}
