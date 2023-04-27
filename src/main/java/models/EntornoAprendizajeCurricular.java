package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "entornoaprendizajescurriculares")
public class EntornoAprendizajeCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntornoCurricular")
    private Integer idEntornoCurricular;

    @Column(name = "instalaciones")
    private String instalaciones;

    @Column(name = "faseTeorica")
    private String faseTeorica;

    @Column(name = "fasePractica")
    private String fasePractica ;

    // se relaciona con curriculo
    @ManyToOne
    @JoinColumn(name="idDisenioCurricular",referencedColumnName ="idDisenioCurricular")
    private DisenioCurricular disenioCurricular;
}
