package com.capacitaciones.continuas.repositorys.Secondary;

import com.capacitaciones.continuas.Modelos.Secondary.EstudianteFenix;
import com.capacitaciones.continuas.Modelos.Secondary.PersonaFenix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaFenixRepository extends JpaRepository<PersonaFenix, String> {

    public PersonaFenix findByIdentificacion(@Param("ci") String ci);

}
