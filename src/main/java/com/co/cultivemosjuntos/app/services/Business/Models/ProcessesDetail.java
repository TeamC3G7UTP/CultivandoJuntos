package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;

public class ProcessesDetail {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private PlantResponse plant;

    @Setter
    @Getter
    private boolean sown;

    @Setter
    @Getter
    private boolean germination;

    @Setter
    @Getter
    private boolean transplanted;

    @Setter
    @Getter
    private boolean irrigation;

    @Setter
    @Getter
    private boolean harvest;

    @Setter
    @Getter
    private boolean finalized;
}
