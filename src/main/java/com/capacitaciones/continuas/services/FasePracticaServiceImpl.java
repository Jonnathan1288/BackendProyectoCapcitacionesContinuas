package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.FasePractica;
import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.repositorys.Primarys.FasePracticaRepository;
import com.capacitaciones.continuas.repositorys.Primarys.FaseTeoricaRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FasePracticaServiceImpl extends GenericServiceImplv2<FasePractica, Integer> implements FasePracticaService {

    @Autowired
    private FasePracticaRepository fasePracticaRepository;

    @Override
    public GenericRepository<FasePractica, Integer> getDao() {
        return fasePracticaRepository;
    }


}
