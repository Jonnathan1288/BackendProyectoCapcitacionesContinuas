package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Provincia;
import com.capacitaciones.continuas.repositorys.Primarys.ProvinciaRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl extends GenericServiceImpl<Provincia, Integer> implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public CrudRepository<Provincia, Integer> getDao() {
        return provinciaRepository;
    }
}
