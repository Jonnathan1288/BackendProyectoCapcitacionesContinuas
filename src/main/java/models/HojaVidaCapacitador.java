package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "hojavidacapacitadores")
public class HojaVidaCapacitador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHojaVida")
    private Integer idHojaVida;

    @Column(name = "experiencialLaboral")
    private String  experiencialLaboral;

    @Column(name = "sobreMi")
    private String sobreMi;

    @Column(name = "experienciaEscolar")
    private String  experienciaEscolar;

    @Column(name = "destrezas")
    private String destrezas;

    @Column(name = "idiomas")
    private String idiomas;


    // Relacion con capacitador
    @OneToOne
    @JoinColumn(name = "idCapacitador", referencedColumnName = "idCapacitador")
    private Capacitador capacitador;

}
