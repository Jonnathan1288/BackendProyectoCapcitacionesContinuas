package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Canton;
import com.capacitaciones.continuas.repositorys.Primarys.CantonRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantonServiceImpl extends GenericServiceImplv2<Canton, Integer> implements CantonService{
    @Autowired
    private CantonRepository cantonRepository;
    @Override
    public GenericRepository<Canton, Integer> getDao() {
        return cantonRepository;
    }


    @Override
    public List<Canton> findByProvinciaIdProvincia(Integer idProvincia) {
        return cantonRepository.findByProvinciaIdProvincia(idProvincia);
    }
}
