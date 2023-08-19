package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.CodeExcel;
import com.capacitaciones.continuas.interfaces.CodesExcelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeExcelRepositry extends JpaRepository<CodeExcel, Integer> {

    @Query("SELECT c.idCodeExel as idCodeExel, c.nombreDocumentoExcel as nombreDocumentoExcel, c.statusCodeExcel as statusCodeExcel, c.codigosCourseExcel as codigosCourseExcel, u.idUsuario as idUsuario FROM CodeExcel c INNER JOIN c.usuario u WHERE u.idUsuario = :idUser AND c.statusCodeExcel = TRUE")
    public List<CodesExcelUser> findCodesExcelByUsuarioIdUsuario(@Param("idUser") Integer idUser);

}
