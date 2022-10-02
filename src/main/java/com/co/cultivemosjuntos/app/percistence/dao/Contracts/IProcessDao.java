package com.co.cultivemosjuntos.app.percistence.dao.Contracts;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.Generic.IDaoRepository;
import com.co.cultivemosjuntos.app.percistence.models.Entities.ProcessEntity;

import java.util.List;

public interface IProcessDao extends IDaoRepository<ProcessEntity> {

    public List<ProcessEntity> processesForUser(Long userId);
    public boolean validateAssignmentProcesses(Long userId, Long plantId);

}
