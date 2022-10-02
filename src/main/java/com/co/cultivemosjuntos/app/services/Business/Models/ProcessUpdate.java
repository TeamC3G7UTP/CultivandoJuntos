package com.co.cultivemosjuntos.app.services.Business.Models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

public class ProcessUpdate {

    @NotEmpty
    @Setter
    @Getter
    private Long processId;

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
