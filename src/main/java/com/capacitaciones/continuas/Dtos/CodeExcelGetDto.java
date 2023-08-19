package com.capacitaciones.continuas.dtos;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CodeExcelGetDto {

    private Integer idCodeExel;

    private String nombreDocumentoExcel;

    private List<Integer> codigosCourseExcel;

    private Boolean statusCodeExcel;

    private Integer idUsuario;
}
