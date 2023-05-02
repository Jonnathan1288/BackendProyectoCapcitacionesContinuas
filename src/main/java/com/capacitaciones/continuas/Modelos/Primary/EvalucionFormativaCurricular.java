package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "evalucionformativacurriculares")
public class EvalucionFormativaCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvalucionFormativaCurricular")
    private Integer idEvalucionFormativaCurricular;

    @Column(name = "tecnicaFormativa")
    private String tecnicaFormativa;

    @Column(name = "instrumnetoFormativa")
    private String instrumnetoFormativa;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="idDisenioCurricular",referencedColumnName ="idDisenioCurricular")
    private DisenioCurricular disenioCurricular;
}
