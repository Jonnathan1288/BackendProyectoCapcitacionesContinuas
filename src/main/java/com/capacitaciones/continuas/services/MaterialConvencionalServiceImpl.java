package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.MaterialConvencional;
import com.capacitaciones.continuas.repositorys.MaterialConvencionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MaterialConvencionalServiceImpl extends GenericServiceImpl<MaterialConvencional, Integer> implements MaterialConvencionalService {

    @Autowired
    private MaterialConvencionalRepository recursoDidacticoRepository;

    @Override
    public CrudRepository<MaterialConvencional, Integer> getDao() {
        return recursoDidacticoRepository;
    }
}
