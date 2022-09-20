package com.co.cultivemosjuntos.app.services.Business.Models;


import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;


public class UserLogin implements Serializable  {

    @Serial
    private  static final long serialVersionUID = 1L;


    @NotEmpty
    @Setter @Getter
    private String username;

    @NotEmpty
    @Setter @Getter
    private String password;
}
