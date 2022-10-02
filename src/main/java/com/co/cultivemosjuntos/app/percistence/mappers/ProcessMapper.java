package com.co.cultivemosjuntos.app.percistence.mappers;

import com.co.cultivemosjuntos.app.percistence.mappers.Security.UserMapper;
import com.co.cultivemosjuntos.app.percistence.models.Entities.PlantEntity;
import com.co.cultivemosjuntos.app.percistence.models.Entities.ProcessEntity;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.*;

import java.util.ArrayList;
import java.util.List;

public class ProcessMapper {


    public static UserProcess proccesesByUser(List<ProcessEntity> processes) {
        UserProcess userProcesses = null;
        if (!processes.isEmpty()) {
            userProcesses = new UserProcess();
            userProcesses.setId(processes.get(0).getUser().getId());
            userProcesses.setName(processes.get(0).getUser().getName());
            userProcesses.setLastName(processes.get(0).getUser().getLastName());
            userProcesses.setEmail(processes.get(0).getUser().getEmail());
            userProcesses.setUsername(processes.get(0).getUser().getUsername());
            List<ProcessesDetail> processesDetailList = new ArrayList<>();
            processes.forEach(process -> processesDetailList.add(getProcessDetail(process)));
            userProcesses.setProcesses(processesDetailList);
        }

        return userProcesses;
    }

    public static ProcessEntity processMapper(UserEntity user, PlantEntity plant) {
        ProcessEntity processEntity = null;
        if (user != null && plant != null) {
            processEntity = new ProcessEntity();
            processEntity.setUser(user);
            processEntity.setPlant(plant);
            processEntity.setSown(false);
            processEntity.setGermination(false);
            processEntity.setTransplanted(false);
            processEntity.setIrrigation(false);
            processEntity.setHarvest(false);
            processEntity.setFinalized(false);
        }
        return processEntity;
    }

    public static ProcessEntity processMapper(ProcessUpdate processUpdate, ProcessEntity processEntity) {

        if (processEntity != null && processUpdate != null) {
            processEntity.setSown(processUpdate.isSown());
            processEntity.setGermination(processUpdate.isGermination());
            processEntity.setTransplanted(processUpdate.isTransplanted());
            processEntity.setIrrigation(processUpdate.isIrrigation());
            processEntity.setHarvest(processUpdate.isHarvest());
            processEntity.setFinalized(processUpdate.isFinalized());
        }
        return processEntity;
    }

    public static List<ProcessResponse> processResponseMapper(List<ProcessEntity> processes) {
        List<ProcessResponse> responses = new ArrayList<>();
        if (!processes.isEmpty()) {
            processes.forEach(processEntity -> responses.add(getProcessResponse(processEntity)));
        }
        return responses;
    }

    public static ProcessResponse processResponseMapper(ProcessEntity processes) {
        return getProcessResponse(processes);
    }

    private static ProcessResponse getProcessResponse(ProcessEntity process) {
        ProcessResponse processResponse = null;
        if (process != null) {
            processResponse = new ProcessResponse();
            processResponse.setId(process.getId());
            processResponse.setUser(UserMapper.userMapper(process.getUser()));
            processResponse.setPlant(PlantMapper.plantMapper(process.getPlant()));
            processResponse.setSown(process.isSown());
            processResponse.setGermination(process.isGermination());
            processResponse.setTransplanted(process.isTransplanted());
            processResponse.setIrrigation(process.isIrrigation());
            processResponse.setHarvest(process.isHarvest());
            processResponse.setFinalized(process.isFinalized());
        }
        return processResponse;
    }

    private static ProcessesDetail getProcessDetail(ProcessEntity process) {
        ProcessesDetail processesDetail = null;
        if (process != null) {
            processesDetail = new ProcessesDetail();
            processesDetail.setId(process.getId());
            processesDetail.setPlant(PlantMapper.plantMapper(process.getPlant()));
            processesDetail.setSown(process.isSown());
            processesDetail.setGermination(process.isGermination());
            processesDetail.setTransplanted(process.isTransplanted());
            processesDetail.setIrrigation(process.isIrrigation());
            processesDetail.setHarvest(process.isHarvest());
            processesDetail.setFinalized(process.isFinalized());
        }
        return processesDetail;
    }


}
