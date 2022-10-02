package com.co.cultivemosjuntos.app.services.Contracts;

import com.co.cultivemosjuntos.app.percistence.models.Entities.ProcessEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.ProcessCreate;
import com.co.cultivemosjuntos.app.services.Business.Models.ProcessResponse;
import com.co.cultivemosjuntos.app.services.Business.Models.ProcessUpdate;
import com.co.cultivemosjuntos.app.services.Business.Models.UserProcess;

import java.util.List;


public interface IProcessService {

    boolean save(ProcessCreate processCreate);

    boolean delete(Long id);

    boolean update(ProcessUpdate processUpdate);

    ProcessResponse get(Long id);

    List<ProcessResponse> getAll();

    UserProcess processesForUser(Long userId);


}
