package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Contracts.IPlantService;
import com.co.cultivemosjuntos.app.services.Contracts.IUserService;
import com.co.cultivemosjuntos.app.utils.Helpers.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/Plant")
public class PlantController {

    @Autowired
    private IPlantService plantService;

    @GetMapping(value = "/Plants")
    public Map<String, Object> getPlants() {
        return ApiResponse.responseMethod(plantService.getAll());
    }
    @GetMapping(value = "/Plant/{id}")
    public Map<String, Object> getPlant(@PathVariable Long id) {
        return ApiResponse.responseMethod(plantService.get(id));
    }
}
