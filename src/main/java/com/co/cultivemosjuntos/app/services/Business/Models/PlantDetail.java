package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;

public class PlantDetail {

    @Getter
    @Setter
    private String typeName;

    @Getter
    @Setter
    private String solarIntensity;

    @Getter
    @Setter
    private String dificulty;

    @Getter
    @Setter
    private Float space;

    @Getter
    @Setter
    private String thermalFloor;
}
