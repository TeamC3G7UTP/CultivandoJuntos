package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class User {

    @NotEmpty
    @Setter @Getter
    private String name;

    @NotEmpty
    @Setter @Getter
    private String lastName;

    @NotEmpty
    @Email
    @Setter @Getter
    private String email;

    @NotEmpty
    @Setter @Getter
    private String username;

    @NotEmpty
    @Setter @Getter
    private LocalDate creationDate;

    @NotEmpty
    @Setter @Getter
    private String password;


    @Setter @Getter
    private boolean firstAdmission;
}

