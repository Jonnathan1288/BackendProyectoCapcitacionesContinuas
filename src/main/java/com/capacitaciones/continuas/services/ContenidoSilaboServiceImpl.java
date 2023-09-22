package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ContenidoSilabo;
import com.capacitaciones.continuas.repositorys.Primarys.ContenidoSilaboRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoSilaboServiceImpl extends GenericServiceImplv2<ContenidoSilabo, Integer> implements ContenidoSilaboService{
    @Autowired
    private ContenidoSilaboRepository contenidoSilaboRepository;
    @Override
    public GenericRepository<ContenidoSilabo, Integer> getDao() {
        return contenidoSilaboRepository;
    }

    @Override
    public List<ContenidoSilabo> findBySilaboIdSilabo(Integer idSilabo) {
        return contenidoSilaboRepository.findBySilaboIdSilabo(idSilabo);
    }
}
