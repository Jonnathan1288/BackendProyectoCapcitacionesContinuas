package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Integer> {
    public Usuario findByUsernameAndPassword(String username, String password);

    public Boolean existsByUsername(String username);


    public Usuario findByTokenPassword(String tokenPassword);

    Usuario findByUsername(String username);

    Usuario findByPersonaIdentificacion(String cedula);

    public Usuario findByPersonaCorreo(String correo);

    public Boolean existsByPersonaCorreo(String email);

    @Modifying
    @Query("UPDATE Usuario u SET u.fotoPerfil = :picture WHERE u.idUsuario = :idUser")
    public Integer updatePictureUser(@Param("idUser") Integer idUser, @Param("picture") String picture);

}
