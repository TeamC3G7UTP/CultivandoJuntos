package com.co.cultivemosjuntos.app.percistence.models.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TCJ_PLANTA")
@ToString
public class PlantEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_tipo_planta")
    private TypePlantEntity typePlant;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String name;

    @Getter
    @Setter
    @Column(name = "informacion_general")
    private String generalInformation;

    @Getter
    @Setter
    @Column(name = "aporte_nutricional")
    private String nutritionalContribution;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_luz_solar")
    private SunlightEntity sunlight;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_dificultad")
    private DificultyEntity dificulty;

    @Getter
    @Setter
    @Column(name = "tiempo_germinacion")
    private int germinationTime;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_espacio")
    private SpaceEntity space;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_piso_termico")
    private ThermalFloorEntity thermalFloor;

    @Getter
    @Setter
    @Column(name = "url_imagen")
    private String ImageUrl;


}
