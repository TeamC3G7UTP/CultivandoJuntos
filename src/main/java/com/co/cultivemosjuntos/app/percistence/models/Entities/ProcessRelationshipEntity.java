package com.co.cultivemosjuntos.app.percistence.models.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TCJ_RELACION_PROCESOS")
@ToString
public class ProcessRelationshipEntity  implements Serializable {

    @Serial
    private  static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_planta")
    private PlantEntity plant;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity user;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_proceso")
    private ProcessEntity process;

}
