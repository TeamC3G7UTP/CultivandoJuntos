package com.co.cultivemosjuntos.app.percistence.mappers;

import com.co.cultivemosjuntos.app.percistence.models.Entities.PlantEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.PlantDetail;
import com.co.cultivemosjuntos.app.services.Business.Models.PlantResponse;

import java.util.ArrayList;
import java.util.List;

public class PlantMapper {

    public static List<PlantResponse> plantMapper(List<PlantEntity> plants) {
        List<PlantResponse> responses = new ArrayList<>();
        if (!plants.isEmpty()) {
            plants.forEach(plantEntity -> responses.add(getPlanResponse(getDetail(plantEntity), plantEntity)));
        }
        return responses;
    }

    public static PlantResponse plantMapper(PlantEntity plantEntity) {
        return getPlanResponse(getDetail(plantEntity), plantEntity);
    }

    private static List<PlantDetail> getDetail(PlantEntity plantEntity) {
        PlantDetail plantDetail = new PlantDetail();
        if (plantEntity != null) {
            plantDetail.setTypeName(plantEntity.getTypePlant().getTypeName());
            plantDetail.setSolarIntensity(plantEntity.getSunlight().getSolarIntensity());
            plantDetail.setDificulty(plantEntity.getDificulty().getDescription());
            plantDetail.setSpace(plantEntity.getSpace().getSpace());
            plantDetail.setThermalFloor(plantEntity.getThermalFloor().getDescription());
        }
        return List.of(plantDetail);
    }

    private static PlantResponse getPlanResponse(List<PlantDetail> detailList, PlantEntity plantEntity) {
        PlantResponse plantResponse = new PlantResponse();
        if (!detailList.isEmpty() && plantEntity != null) {
            plantResponse.setId(plantEntity.getId());
            plantResponse.setName(plantEntity.getName());
            plantResponse.setGeneralInformation(plantEntity.getGeneralInformation());
            plantResponse.setNutritionalContribution(plantEntity.getNutritionalContribution());
            plantResponse.setGerminationTime(plantEntity.getGerminationTime());
            plantResponse.setImageUrl(plantEntity.getImageUrl() != null
                    ? plantResponse.getImageUrl() : "");
            plantResponse.setPlantDetails(detailList);
        }
        return plantResponse;
    }
}
