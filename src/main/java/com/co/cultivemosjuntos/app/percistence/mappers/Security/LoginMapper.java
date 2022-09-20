package com.co.cultivemosjuntos.app.percistence.mappers.Security;

import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;

import java.time.LocalDate;

public class LoginMapper {

    public static UserLogin userMapper(UserEntity user) {
        UserLogin userLogin = new UserLogin();
        if (user != null) {
            userLogin.setUsername(user.getUsername());
            userLogin.setPassword(user.getPassword());
        }
        return userLogin;
    }
}
