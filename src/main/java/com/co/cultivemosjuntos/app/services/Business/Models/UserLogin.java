package com.co.cultivemosjuntos.app.services.Business.Models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class UserLogin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @NotEmpty
    @Setter
    @Getter
    private String username;

    @NotEmpty
    @Setter
    @Getter
    private String password;
}
