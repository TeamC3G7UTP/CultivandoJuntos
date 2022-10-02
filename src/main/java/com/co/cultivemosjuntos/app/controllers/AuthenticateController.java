package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;
import com.co.cultivemosjuntos.app.services.Contracts.IAuthenticateService;
import com.co.cultivemosjuntos.app.services.Contracts.IUserService;
import com.co.cultivemosjuntos.app.utils.Helpers.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("api/v1/Authenticate")
public class AuthenticateController {

    @Autowired
    private IAuthenticateService authenticateService;

    @PostMapping(value = "/Login")
    public Map<String, Object> login(@RequestBody UserLogin userLogin) {
        return ApiResponse.responseMethod(authenticateService.login(userLogin));
    }
    @PostMapping(value = "/RequestRecovery")
    public Map<String, Object> requestRecovery(@RequestBody UserLogin userLogin){
        return  ApiResponse.responseMethod(authenticateService.requestRecovery(userLogin));
    }
    @PostMapping(value = "/RecoveryPassword")
    public Map<String, Object> recoveryPassword(@RequestBody UserLogin userLogin){
        return  ApiResponse.responseMethod(authenticateService.requestRecovery(userLogin));
    }

}
