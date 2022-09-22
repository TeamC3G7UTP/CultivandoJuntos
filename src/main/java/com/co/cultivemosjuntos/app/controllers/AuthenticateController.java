package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthenticateController {

    @PostMapping(value = "/login")
    public String login(@Valid UserLogin userLogin, BindingResult result){
        //Metodo de controlador para inciar sesion
        return  "redirect:home";
    }

    @PostMapping(value = "/RequestRecovery")
    public String requestRecovery(@Valid UserLogin userLogin, BindingResult result){
        //Metodo de controlador para validar si se puede restablecer la contraseña del usuario
        //si el usuario existe en base de datos
        return  "redirect:home";
    }

    @PostMapping(value = "/RecoveryPassword")
    public String recoveryPassword(@Valid UserLogin userLogin, BindingResult result){
        //Metodo de controlador para restablecer contraseña
        return  "redirect:home";
    }

}
