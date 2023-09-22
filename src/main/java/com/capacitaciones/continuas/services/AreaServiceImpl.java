package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.repositorys.Primarys.AreaRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends GenericServiceImplv2<Area, Integer> implements AreaService{
    @Autowired
    private AreaRepository areaRepository;
    @Override
    public GenericRepository<Area, Integer> getDao() {
        return areaRepository;
    }
}
