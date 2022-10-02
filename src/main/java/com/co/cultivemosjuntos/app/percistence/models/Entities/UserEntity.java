package com.co.cultivemosjuntos.app.percistence.models.Entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TCJ_USUARIO")
@ToString
@EqualsAndHashCode
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "nombre")
    private String name;

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "apellido")
    private String lastName;

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "correo")
    private String email;

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "nombre_usuario")
    private String username;

    @Setter
    @Getter
    @Column(name = "fecha_creacion")
    private LocalDate creationDate;

    @NotEmpty
    @Setter
    @Getter
    @Column(name = "contrasena")
    private String password;

    @Setter
    @Getter
    @Column(name = "primer_ingreso", nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean firstAdmission;


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
