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

        if(result.hasErrors()){
            return "modal:error";
        }

        //se realiza una accion
        return  "redirect:home";
    }

}
