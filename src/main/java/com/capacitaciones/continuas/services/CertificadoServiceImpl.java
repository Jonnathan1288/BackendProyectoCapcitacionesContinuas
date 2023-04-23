package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.Capacitador;
import com.capacitaciones.continuas.models.Certificado;
import com.capacitaciones.continuas.repositorys.CapacitadorRepository;
import com.capacitaciones.continuas.repositorys.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificadoServiceImpl extends GenericServiceImpl<Certificado, Integer> implements CertificadoService{
    @Autowired
    private CertificadoRepository certificadoRepository;
    @Override
    public CrudRepository<Certificado, Integer> getDao() {
        return certificadoRepository;
    }
}
