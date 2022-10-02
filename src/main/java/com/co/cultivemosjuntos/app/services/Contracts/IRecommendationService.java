package com.co.cultivemosjuntos.app.services.Contracts;

import com.co.cultivemosjuntos.app.services.Business.Models.PlantResponse;
import com.co.cultivemosjuntos.app.services.Business.Models.Recommendation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRecommendationService {

    List<PlantResponse> plantRecommendation(Recommendation recommendation);
}
