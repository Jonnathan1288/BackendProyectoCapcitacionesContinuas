package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EstrategiasMetodologica;
import com.capacitaciones.continuas.repositorys.Primarys.EstrategiaMetodologicaRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstrategiaMetodologicaServiceImpl extends GenericServiceImplv2<EstrategiasMetodologica, Integer> implements EstrategiaMetodologicaService {
    @Autowired
    private EstrategiaMetodologicaRepository estrategiaMetodologicaRepository;
    @Override
    public GenericRepository<EstrategiasMetodologica, Integer> getDao() {
        return estrategiaMetodologicaRepository;
    }

    public List<EstrategiasMetodologica> findBySilaboIdSilabo(Integer idSilabo) {
        return estrategiaMetodologicaRepository.findBySilaboIdSilabo(idSilabo);
    }
}
