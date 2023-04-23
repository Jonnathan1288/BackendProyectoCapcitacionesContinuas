package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Integer> {
}
