package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.Curso;
import com.capacitaciones.continuas.models.DetalleEvaluacionFinal;
import com.capacitaciones.continuas.repositorys.CursoRepositry;
import com.capacitaciones.continuas.repositorys.DetalleEvaluacionFinalRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleEvaluacionFinalServiceImpl extends GenericServiceImpl<DetalleEvaluacionFinal, Integer> implements DetalleEvaluacionFinalService{
    @Autowired
    private DetalleEvaluacionFinalRepositorty detalleEvaluacionFinalRepositorty;
    @Override
    public CrudRepository<DetalleEvaluacionFinal, Integer> getDao() {
        return detalleEvaluacionFinalRepositorty;
    }
}
