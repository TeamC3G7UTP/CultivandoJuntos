package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.ProcessCreate;
import com.co.cultivemosjuntos.app.services.Business.Models.ProcessUpdate;
import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Contracts.IProcessService;
import com.co.cultivemosjuntos.app.services.Contracts.IUserService;
import com.co.cultivemosjuntos.app.utils.Helpers.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("api/v1/Process")
public class ProcessController {

    @Autowired
    private IProcessService processService;

    @PostMapping(value = "/AddProcess")
    public Map<String, Object> addProcess(@RequestBody ProcessCreate processCreate) {
        return ApiResponse.responseMethod(processService.save(processCreate));
    }
    @PutMapping(value = "/UpdateProcess")
    public Map<String, Object> updateProcess(@RequestBody ProcessUpdate processUpdate) {
        return ApiResponse.responseMethod(processService.update(processUpdate));
    }
    @GetMapping(value = "/Processes")
    public Map<String, Object> getProcesses() {
        return ApiResponse.responseMethod(processService.getAll());
    }
    @GetMapping(value = "/Process/{id}")
    public Map<String, Object> getProcess(@PathVariable Long id) {
        return ApiResponse.responseMethod(processService.get(id));
    }
    @GetMapping(value = "/ProcessesByUser/{id}")
    public Map<String, Object> processesByUser(@PathVariable Long id) {
        return ApiResponse.responseMethod(processService.processesForUser(id));
    }
    @DeleteMapping(value = "/DeleteProcess/{id}")
    public Map<String, Object> deleteProcess(@PathVariable Long id) {
        return ApiResponse.responseMethod(processService.delete(id));
    }

}
