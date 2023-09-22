package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ModalidadCurso;
import com.capacitaciones.continuas.repositorys.Primarys.ModalidadRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ModalidadCursoServiceImpl extends GenericServiceImplv2<ModalidadCurso, Integer> implements ModalidadCursoService {

    @Autowired
    private ModalidadRepository modalidadRepository;

    @Override
    public GenericRepository<ModalidadCurso, Integer> getDao() {
        return modalidadRepository;
    }
}
