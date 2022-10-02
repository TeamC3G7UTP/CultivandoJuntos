package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class Recommendation {

    @NotEmpty
    @Setter
    @Getter
    private Long plantingExperience;

    @NotEmpty
    @Setter
    @Getter
    private Float space;

    @NotEmpty
    @Setter
    @Getter
    private Long thermalFloor;

    @NotEmpty
    @Setter
    @Getter
    private Long sunlight;

}
