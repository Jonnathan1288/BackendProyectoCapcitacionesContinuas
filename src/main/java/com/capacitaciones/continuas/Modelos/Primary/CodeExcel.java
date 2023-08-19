package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "codesExel")
public class CodeExcel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCodeExel")
    private Integer idCodeExel;

    @Column(name = "nombreDocumentoExcel", length = 300)
    private String nombreDocumentoExcel;


    @Column(name = "idCodeExcel", length = 200)
    private String codigosCourseExcel;

    @Column(name = "statusCodeExcel", columnDefinition = "BOOLEAN")
    private Boolean statusCodeExcel;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    public CodeExcel(String nombreDocumentoExcel, String codigosCourseExcel, Boolean statusCodeExcel, Usuario usuario) {
        this.nombreDocumentoExcel = nombreDocumentoExcel;
        this.codigosCourseExcel = codigosCourseExcel;
        this.statusCodeExcel = statusCodeExcel;
        this.usuario = usuario;
    }
}