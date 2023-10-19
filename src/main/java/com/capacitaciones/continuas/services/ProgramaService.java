package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Programas;
import com.capacitaciones.continuas.interfaces.ChartProgramaCourse;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface ProgramaService extends GenericService<Programas, Integer> {

    public List<ChartProgramaCourse> findProgramaCourseChart();
}
