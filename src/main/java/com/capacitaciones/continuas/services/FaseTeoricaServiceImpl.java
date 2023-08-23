package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.repositorys.Primarys.FaseTeoricaRepository;
import com.capacitaciones.continuas.repositorys.Primarys.InstalacionRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaseTeoricaServiceImpl extends GenericServiceImplv2<FaseTeorica, Integer> implements FaseTeoricaService {

    @Autowired
    private FaseTeoricaRepository faseTeoricaRepository;

    @Override
    public GenericRepository<FaseTeorica, Integer> getDao() {
        return faseTeoricaRepository;
    }


}
