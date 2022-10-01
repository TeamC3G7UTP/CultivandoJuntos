package com.co.cultivemosjuntos.app.services.Business.Models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class PlantResponse {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String generalInformation;

    @Getter
    @Setter
    private String nutritionalContribution;

    @Getter
    @Setter
    private int germinationTime;

    @Getter
    @Setter
    private String ImageUrl;

    @Getter
    @Setter
    List<PlantDetail> plantDetails;
}
