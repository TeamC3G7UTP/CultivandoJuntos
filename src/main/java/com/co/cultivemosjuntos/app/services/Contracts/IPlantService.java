package com.co.cultivemosjuntos.app.services.Contracts;

import com.co.cultivemosjuntos.app.percistence.models.Entities.PlantEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.PlantResponse;


import java.util.List;
import java.util.Optional;

public interface IPlantService {

    List<PlantResponse> getAll();

    PlantResponse get(Long id);
}
