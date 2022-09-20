package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UserResponse {

    @Id
    @Getter @Setter
    private Long id;

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


}
