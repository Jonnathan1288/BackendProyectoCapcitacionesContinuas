package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "registrofotograficocursos")
public class RegistroFotograficoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRegistroFotograficoCurso")
    private Integer idRegistroFotograficoCurso;

    @Column(name = "descripcionFoto")
    private String descripcionFoto;

    @Column(name = "foto",  columnDefinition = "LONGBLOB")
    private String foto;

    @Column(name = "fecha")
    private LocalDate fecha;

    //viene la llave de id curso

    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName ="idCurso")
    private Curso curso;

}
