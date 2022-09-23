package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Business.Models.UserResponse;
import com.co.cultivemosjuntos.app.services.Contracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/SaveUser")
    public String saveUser(@Valid User user, BindingResult result) {
        //Metodo de controlador para inciar sesion
        return "redirect:home";
    }

    @GetMapping(value = "/GetUsers")
    public String getUsers(Model model) {
        List<UserResponse> users =  userService.getAll();
        model.addAttribute("data", Objects.requireNonNullElse(users, "No hay usuarios en base de datos"));
        //Cambiar a nombre de la vista
        return "redirect:home";
    }

    @GetMapping(value = "/GetUser/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        UserResponse user =  userService.get(id).orElse(null);
        model.addAttribute("data", Objects.requireNonNullElse(user, "Usuario no encontrado en base de datos"));
        //Cambiar a nombre de la vista
        return "redirect:home";
    }
}
