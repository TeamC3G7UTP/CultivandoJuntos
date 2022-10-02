package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@ToString
@EqualsAndHashCode
public class UserResponse {

    @Id
    @Getter
    @Setter
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
