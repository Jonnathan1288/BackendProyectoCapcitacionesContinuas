package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArea")
    private Integer idArea;

    @Column(name = "codigoArea")
    private String codigoArea;

    @Column(name = "nombreArea")
    private String nombreArea;

    @Column(name = "estadoAreaActivo")
    private Boolean estadoAreaActivo;

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "area")
    private List<Especialidad> Especialidad;

}
