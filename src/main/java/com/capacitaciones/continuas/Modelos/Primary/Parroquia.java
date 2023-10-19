package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "parroquias")
public class Parroquia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parroquia")
    private Integer idParroquia;

    @Column(name = "parroquia", length = 100, unique = true)
    private String parroquia;

    @ManyToOne
    @JoinColumn(name = "id_canton", referencedColumnName = "id_canton")
    private Canton canton;

    @JsonIgnore
    @OneToMany(mappedBy = "parroquia")
    private List<Curso> cursoList;
}
