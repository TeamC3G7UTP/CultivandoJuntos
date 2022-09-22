package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @PostMapping(value = "/SaveUser")
    public String saveUser(@Valid User user, BindingResult result) {
        //Metodo de controlador para inciar sesion
        return "redirect:home";
    }

    @GetMapping(value = "/GetUsers")
    public String getUsers(Model model  ) {

        return "redirect:home";
    }
}
