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
@Table(name = "areas")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer idArea;

    @Column(name = "codigo_area", length = 50)
    private String codigoArea;

    @Column(name = "nombre_area", length = 500)
    private String nombreArea;

    @Column(name = "estado_area_activo", columnDefinition = "BOOLEAN")
    private Boolean estadoAreaActivo;

    // REFERENCIA DE LAS RELACIONES
    @JsonIgnore
    @OneToMany(mappedBy = "area")
    private List<Especialidad> Especialidad;

}
