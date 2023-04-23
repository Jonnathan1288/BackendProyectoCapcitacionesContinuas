package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.Notas;
import com.capacitaciones.continuas.repositorys.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class NotasSeviceImpl extends GenericServiceImpl<Notas, Integer> implements NotasSevice {

    @Autowired
    NotasRepository notasRepository;

    @Override
    public CrudRepository<Notas, Integer> getDao() {
        return notasRepository;
    }
}