package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.CodeExcel;
import com.capacitaciones.continuas.interfaces.CodesExcelUser;

import java.util.List;

public interface CodeExcelService extends GenericService<CodeExcel, Integer>{

    public List<CodesExcelUser> findCodesExcelByUsuarioIdUsuario(Integer idUser);

}
