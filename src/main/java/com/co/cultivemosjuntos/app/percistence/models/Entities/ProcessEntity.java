package com.co.cultivemosjuntos.app.percistence.models.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TCJ_PROCESOS")
@ToString
public class ProcessEntity implements Serializable {

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
    @JoinColumn(name = "id_usuario")
    private UserEntity user;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_planta")
    private PlantEntity plant;

    @Setter
    @Getter
    @Column(name = "sembrado", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean sown;

    @Setter
    @Getter
    @Column(name = "germinacion", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean germination;

    @Setter
    @Getter
    @Column(name = "transplantado", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean transplanted;

    @Setter
    @Getter
    @Column(name = "riego", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean irrigation;

    @Setter
    @Getter
    @Column(name = "cosecha", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean harvest;

    @Setter
    @Getter
    @Column(name = "finalizado", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean finalized;

}
