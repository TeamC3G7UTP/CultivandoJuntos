package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

public class GenericResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    private String message;

    @Setter
    @Getter
    private Object data;
}
