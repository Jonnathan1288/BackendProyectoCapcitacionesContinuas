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
@Table(name = "cantones")
public class Canton implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_canton")
    private Integer idCanton;

    @Column(name = "canton", length = 100, unique = true)
    private String canton;

    @ManyToOne
    @JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia")
    private Provincia provincia;

    @JsonIgnore
    @OneToMany(mappedBy = "canton")
    private List<Parroquia> parroquias;

}
