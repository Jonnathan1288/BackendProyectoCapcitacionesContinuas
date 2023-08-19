package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.CodeExcel;
import com.capacitaciones.continuas.interfaces.CodesExcelUser;
import com.capacitaciones.continuas.repositorys.Primarys.CapacitadorRepository;
import com.capacitaciones.continuas.repositorys.Primarys.CodeExcelRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeExcelServiceImpl extends GenericServiceImpl<CodeExcel, Integer> implements CodeExcelService{
    @Autowired
    private CodeExcelRepositry codeExcelRepositry;

    @Override
    public CrudRepository<CodeExcel, Integer> getDao() {
        return codeExcelRepositry;
    }

    @Override
    public List<CodesExcelUser> findCodesExcelByUsuarioIdUsuario(Integer idUser) {
        return codeExcelRepositry.findCodesExcelByUsuarioIdUsuario(idUser);
    }
}
