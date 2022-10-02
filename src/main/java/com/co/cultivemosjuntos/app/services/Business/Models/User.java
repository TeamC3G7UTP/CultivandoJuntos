package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDate;

@ToString
@EqualsAndHashCode
public class User {

    @NotEmpty
    @Setter
    @Getter
    private String name;

    @NotEmpty
    @Setter
    @Getter
    private String lastName;

    @NotEmpty
    @Email
    @Setter
    @Getter
    private String email;

    @NotEmpty
    @Setter
    @Getter
    private String username;

    @NotEmpty
    @Setter
    @Getter
    private String password;

}

