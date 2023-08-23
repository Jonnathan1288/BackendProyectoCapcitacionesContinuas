package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.repositorys.Primarys.InscritoRepository;
import com.capacitaciones.continuas.repositorys.Primarys.InstalacionRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstalacionServiceImpl extends GenericServiceImplv2<Instalacion, Integer> implements InstalacionService {

    @Autowired
    private InstalacionRepository instalacionRepository;

    @Override
    public GenericRepository<Instalacion, Integer> getDao() {
        return instalacionRepository;
    }


}
