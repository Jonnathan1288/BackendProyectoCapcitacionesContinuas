package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tiposCursos")
public class TipoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoCurso")
    private Integer idTipoCurso;

    @Column(name = "estadoTipoCurso")
    private Boolean estadoTipoCurso;

    @Column(name = "nombreTipoCurso")
    private String nombreTipoCurso;

    @JsonIgnore
    @OneToOne(mappedBy = "tipoCurso")
    private Curso curso;

}
