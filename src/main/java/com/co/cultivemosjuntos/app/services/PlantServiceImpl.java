package com.co.cultivemosjuntos.app.services;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IPlantDao;
import com.co.cultivemosjuntos.app.percistence.mappers.PlantMapper;
import com.co.cultivemosjuntos.app.percistence.mappers.Security.UserMapper;
import com.co.cultivemosjuntos.app.percistence.models.Entities.PlantEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.PlantResponse;
import com.co.cultivemosjuntos.app.services.Business.Models.UserResponse;
import com.co.cultivemosjuntos.app.services.Contracts.IPlantService;
import com.co.cultivemosjuntos.app.utils.Helpers.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements IPlantService {

    @Autowired
    IPlantDao plantDao;

    @Override
    public List<PlantResponse> getAll() {
        return PlantMapper.plantMapper(plantDao.getAll());
    }

    @Override
    public PlantResponse get(Long id) {
        PlantResponse response = null;
        if (!Validate.isValidId(id)) {
            response = PlantMapper.plantMapper(plantDao.get(id).orElse(null));
        }
        return response;
    }
}
