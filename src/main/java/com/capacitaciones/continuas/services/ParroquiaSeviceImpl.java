package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.repositorys.Primarys.ParroquiaRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParroquiaSeviceImpl extends GenericServiceImplv2<Parroquia, Integer> implements ParroquiaService {

    @Autowired
    private ParroquiaRepository parroquiaRepository;

    @Override
    public GenericRepository<Parroquia, Integer> getDao() {
        return parroquiaRepository;
    }


    @Override
    public List<Parroquia> findByCanton_IdCanton(Integer idCanton) {
        return parroquiaRepository.findByCanton_IdCanton(idCanton);
    }
}