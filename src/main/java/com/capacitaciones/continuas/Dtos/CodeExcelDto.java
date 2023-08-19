package com.capacitaciones.continuas.dtos;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Setter
@Getter
public class CodeExcelDto {

    private Integer idCodeExel;

    private String nombreDocumentoExcel;

    private List<Integer> codigosCourseExcel;

    private Boolean statusCodeExcel;

    private Usuario usuario;
}
