package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class ProcessCreate {

    @NotEmpty
    @Setter
    @Getter
    private Long plantId;

    @NotEmpty
    @Setter
    @Getter
    private Long userId;


}
