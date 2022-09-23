package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/Authenticate")
public class AuthenticateController {

    @GetMapping(value = "/login")
    public String login(){

        return  "login/login";
    }

    @PostMapping(value = "/RequestRecovery")
    public String requestRecovery(@Valid UserLogin userLogin, BindingResult result){

        return  "redirect:home";
    }

    @PostMapping(value = "/RecoveryPassword")
    public String recoveryPassword(@Valid UserLogin userLogin, BindingResult result){
        //Metodo de controlador para restablecer contraseña
        return  "redirect:home";
    }

}
