package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Programas;
import com.capacitaciones.continuas.interfaces.ChartProgramaCourse;
import com.capacitaciones.continuas.repositorys.Primarys.ProgramasRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramaServiceImpl extends GenericServiceImpl<Programas, Integer> implements ProgramaService {

    @Autowired
    ProgramasRepository programasRepository;

    @Override
    public CrudRepository<Programas, Integer> getDao() {
        return programasRepository;
    }

    @Override
    public List<ChartProgramaCourse> findProgramaCourseChart() {
        return programasRepository.findProgramaCourseChart();
    }
}
