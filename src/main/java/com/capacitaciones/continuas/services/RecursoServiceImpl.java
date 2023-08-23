package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.Modelos.Primary.Recurso;
import com.capacitaciones.continuas.repositorys.Primarys.InstalacionRepository;
import com.capacitaciones.continuas.repositorys.Primarys.RecursoRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursoServiceImpl extends GenericServiceImplv2<Recurso, Integer> implements RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    @Override
    public GenericRepository<Recurso, Integer> getDao() {
        return recursoRepository;
    }


}
