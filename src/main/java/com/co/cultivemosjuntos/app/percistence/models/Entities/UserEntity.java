package com.co.cultivemosjuntos.app.percistence.models.Entities;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TCJ_USUARIO")
@ToString
public class UserEntity implements Serializable {

    @Serial
    private  static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Setter @Getter @Column(name = "nombre")
    private String name;

    @NotEmpty
    @Setter @Getter @Column(name = "apellido")
    private String lastName;

    @NotEmpty
    @Email
    @Setter @Getter @Column(name = "correo")
    private String email;

    @NotEmpty
    @Setter @Getter @Column(name = "nombre_usuario")
    private String username;

    @NotEmpty
    @Setter @Getter @Column(name = "fecha_creacion")
    private LocalDate creationDate;

    @NotEmpty
    @Setter @Getter @Column(name = "contrasena")
    private String password;


    @Setter @Getter @Column(name = "primer_ingreso")
    private boolean firstAdmission;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
