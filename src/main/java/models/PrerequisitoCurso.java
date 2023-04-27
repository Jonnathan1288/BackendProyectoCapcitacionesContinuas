package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "prerequisitosCursos")
public class PrerequisitoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrerequisitoCurso")
    private Integer idPrerequisitoCurso;

    @Column(name = "estadoPrerequisitoCurso")
    private Boolean estadoPrerequisitoCurso;

    @Column(name = "nombrePrerequisitoCurso")
    private String nombrePrerequisitoCurso;

    @ManyToOne
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
    private Curso curso;

}
