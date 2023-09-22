package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.MaterialConvencional;
import com.capacitaciones.continuas.repositorys.Primarys.MaterialConvencionalRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConvencionalServiceImpl extends GenericServiceImplv2<MaterialConvencional, Integer> implements MaterialConvencionalService {

    @Autowired
    private MaterialConvencionalRepository recursoDidacticoRepository;

    @Override
    public GenericRepository<MaterialConvencional, Integer> getDao() {
        return recursoDidacticoRepository;
    }

    public List<MaterialConvencional> findBySilaboIdSilabo(Integer idSilabo) {
        return recursoDidacticoRepository.findBySilaboIdSilabo(idSilabo);
    }
}
