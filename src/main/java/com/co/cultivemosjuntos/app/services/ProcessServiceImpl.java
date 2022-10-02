package com.co.cultivemosjuntos.app.services;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IPlantDao;
import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IProcessDao;
import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IUserDao;
import com.co.cultivemosjuntos.app.percistence.mappers.ProcessMapper;
import com.co.cultivemosjuntos.app.percistence.models.Entities.PlantEntity;
import com.co.cultivemosjuntos.app.percistence.models.Entities.ProcessEntity;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.ProcessCreate;
import com.co.cultivemosjuntos.app.services.Business.Models.ProcessResponse;
import com.co.cultivemosjuntos.app.services.Business.Models.ProcessUpdate;
import com.co.cultivemosjuntos.app.services.Business.Models.UserProcess;
import com.co.cultivemosjuntos.app.services.Contracts.IProcessService;
import com.co.cultivemosjuntos.app.utils.Helpers.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProcessServiceImpl implements IProcessService {

    @Autowired
    IProcessDao processDao;
    @Autowired
    IUserDao userDao;
    @Autowired
    IPlantDao plantDao;

    @Override
    @Transactional
    public boolean save(ProcessCreate processCreate) {
        boolean result = false;
        if (!Validate.isValidId(processCreate.getUserId())
                && !Validate.isValidId(processCreate.getPlantId())
                && processDao.validateAssignmentProcesses(processCreate.getUserId(), processCreate.getPlantId())) {
            UserEntity user = userDao.get(processCreate.getUserId()).orElse(null);
            PlantEntity plant = plantDao.get(processCreate.getPlantId()).orElse(null);
            if (user != null && plant != null) {
                processDao.save(ProcessMapper.processMapper(user, plant));
                result = true;
            }
        }
        return result;
    }

    @Override
    @Transactional
    public boolean update(ProcessUpdate processUpdate) {
        boolean result = false;
        if (!Validate.isValidId(processUpdate.getProcessId())) {
            var process = processDao.get(processUpdate.getProcessId()).orElse(null);
            if (process != null) {
                result = processDao.update(ProcessMapper.processMapper(processUpdate, process));
            }
        }
        return result;
    }

    @Override
    @Transactional
    public ProcessResponse get(Long id) {
        ProcessResponse processEntity = null;
        if (!Validate.isValidId(id)) {
            processEntity = ProcessMapper.processResponseMapper(processDao.get(id).orElse(null));
        }
        return processEntity;
    }

    @Override
    @Transactional
    public List<ProcessResponse> getAll() {
        return ProcessMapper.processResponseMapper(processDao.getAll());
    }

    @Override
    @Transactional
    public UserProcess processesForUser(Long userId) {
        if (!Validate.isValidId(userId)) {
            return ProcessMapper.proccesesByUser(processDao.processesForUser(userId));
        }
        return null;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        boolean result = false;
        if (!Validate.isValidId(id)) {
            var process = processDao.get(id).orElse(null);
            if (process != null) {
                processDao.delete(process);
                result = true;
            }
        }
        return result;
    }
}
