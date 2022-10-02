package com.co.cultivemosjuntos.app.services.Business.Models;


import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import lombok.Getter;
import lombok.Setter;

public class ProcessResponse {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private UserResponse user;

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
