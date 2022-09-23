package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthenticateController {

    @GetMapping(value = "/login")
    public String login(){
        /**
         *
         * LAS VISTAN DEBE IR DIVIDAS EN CARPETAS DENTRO DEL ESTA CARPETA TEMPLATES
         * LOS ARCHIVOS ESTATICOS COMO LOS JS, CSS , IMG Y INDEX PUEDEN IR EN LA CARPETA ESTATIC
         * EN INDEX PARA HREF DE LOGIN SE LLAMA AL CONTROLADOR Y EL DEVUELVE LA VISTA, SE PUEDE HACER CON JAVASCRIPT USANDO AJAX,FETCH, AXIOS
         * O CUALQUIER OTRO METODOS PARA HACER SOLICITUDES HTTP
         * */
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
