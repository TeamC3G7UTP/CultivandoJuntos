package com.co.cultivemosjuntos.app.services;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IPlantDao;
import com.co.cultivemosjuntos.app.percistence.mappers.PlantMapper;
import com.co.cultivemosjuntos.app.percistence.models.Entities.PlantEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.PlantResponse;
import com.co.cultivemosjuntos.app.services.Business.Models.Recommendation;
import com.co.cultivemosjuntos.app.services.Contracts.IRecommendationService;
import com.co.cultivemosjuntos.app.utils.Helpers.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService implements IRecommendationService {

    @Autowired
    IPlantDao plantDao;

    @Override
    @Transactional
    public List<PlantResponse> plantRecommendation(Recommendation recommendation) {
        if (validateRecommendation(recommendation)) {
            List<PlantEntity> plantEntityList = plantDao.getAll()
                    .stream().filter(x -> x.getDificulty().getId().equals(recommendation.getPlantingExperience()))
                    .filter(x -> recommendation.getSpace() <= x.getSpace().getSpace()
                            || x.getThermalFloor().getId().equals(recommendation.getThermalFloor())
                            || x.getSunlight().getId().equals(recommendation.getSunlight())).collect(Collectors.toList());
            if (!plantEntityList.isEmpty()) {
                return PlantMapper.plantMapper(plantEntityList);
            } else {
                return PlantMapper.plantMapper(plantDao.getAll()
                        .stream()
                        .filter(x -> x.getDificulty().getId() == 1)
                        .collect(Collectors.toList()));
            }
        }
        return null;
    }

    private boolean validateRecommendation(Recommendation recommendation) {

        return !Validate.isValidId(recommendation.getPlantingExperience())
                && !Validate.isValidId(recommendation.getSunlight())
                && !Validate.isValidId(recommendation.getThermalFloor())
                && recommendation.getSpace() > 0;
    }
}
