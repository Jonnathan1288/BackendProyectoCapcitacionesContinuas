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
    @Column(name = "id_registro_fotografico_curso")
    private Integer idRegistroFotograficoCurso;

    @Column(name = "descripcion_foto", length = 1300)
    private String descripcionFoto;

    @Column(name = "foto", length = 300)
    private String foto;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado")
    private Boolean estado;

    //viene la llave de id curso

    @ManyToOne
    @JoinColumn(name="id_curso",referencedColumnName ="id_curso")
    private Curso curso;

}
