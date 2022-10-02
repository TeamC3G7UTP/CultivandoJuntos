package com.co.cultivemosjuntos.app.controllers;

import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Contracts.IUserService;
import com.co.cultivemosjuntos.app.utils.Helpers.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("api/v1/User")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/AddUser")
    public Map<String, Object> addUser(@RequestBody User user) {
        return ApiResponse.responseMethod(userService.save(user));
    }
    @PostMapping(value = "/UpdateUser")
    public Map<String, Object> updateUser(@RequestBody @Valid User user) {
        return ApiResponse.responseMethod(userService.update(user));
    }
    @GetMapping(value = "/Users")
    public Map<String, Object> getUsers() {
       return ApiResponse.responseMethod(userService.getAll());
    }
    @GetMapping(value = "/User/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        return ApiResponse.responseMethod(userService.get(id).orElse(null));
    }
    @GetMapping(value = "/FirstAdmission/{id}")
    public Map<String, Object> firstAdmission(@PathVariable Long id) {
        return ApiResponse.responseMethod(userService.firstAdmission(id));
    }
    @GetMapping(value = "/UserExist/{username}")
    public Map<String, Object> existUserByUserName(@PathVariable String username) {
        return ApiResponse.responseMethod(userService.existsUserByUsername(username));
    }
    @GetMapping(value = "/UserByUsername/{username}")
    public Map<String, Object> getUserByUserName(@PathVariable String username) {
        return ApiResponse.responseMethod(userService.getUserByUsername(username));
    }
    @PutMapping(value = "/UpdateState/{id}")
    public Map<String, Object> updateState(@PathVariable Long id) {
        return ApiResponse.responseMethod(userService.updateState(id));
    }
}
