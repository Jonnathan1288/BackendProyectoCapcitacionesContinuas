package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.PeriodoPrograma;
import com.capacitaciones.continuas.repositorys.Primarys.PeriodoProgramaRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PeriodoProgramaServiceImpl extends GenericServiceImplv2<PeriodoPrograma, Integer> implements PeriodoProgramaService {

    @Autowired
    private PeriodoProgramaRepository periodoProgramaRepository;

    @Override
    public GenericRepository<PeriodoPrograma, Integer> getDao() {
        return periodoProgramaRepository;
    }
}
