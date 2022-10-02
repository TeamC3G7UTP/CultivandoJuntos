package com.co.cultivemosjuntos.app.controllers;


import com.co.cultivemosjuntos.app.services.Business.Models.Recommendation;
import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;
import com.co.cultivemosjuntos.app.services.Contracts.IRecommendationService;
import com.co.cultivemosjuntos.app.utils.Helpers.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/Recommendation")
public class RecommendationController {

    @Autowired
    IRecommendationService recommendationService;

    @PostMapping(value = "/PlantRecommendation")
    public Map<String, Object> getPlantRecommendation(@RequestBody Recommendation recommendation){
        return  ApiResponse.responseMethod(recommendationService.plantRecommendation(recommendation));
    }

}
