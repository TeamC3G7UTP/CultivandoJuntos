package com.co.cultivemosjuntos.app.percistence.mappers.Security;

import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Business.Models.UserResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private UserMapper() {
        throw new IllegalStateException("Clase Mapper");
    }

    public static UserEntity userMapper(User user) {
        UserEntity userEntity = null;
        if (user != null) {
            userEntity = new UserEntity();
            userEntity.setName(user.getName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
            userEntity.setCreationDate(LocalDate.now());
            userEntity.setFirstAdmission(true);
        }
        return userEntity;
    }

    public static UserEntity userUpdateMapper(User user, UserEntity userEntity) {
        if (user != null && userEntity != null) {
            userEntity.setName(user.getName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
        }
        return userEntity;
    }

    public static UserResponse userMapper(UserEntity userEntity) {
        UserResponse user = null;
        if (userEntity != null) {
            user = new UserResponse();
            user.setId(userEntity.getId());
            user.setName(userEntity.getName());
            user.setLastName(userEntity.getLastName());
            user.setEmail(userEntity.getEmail());
            user.setUsername(userEntity.getUsername());
        }
        return user;
    }

    public static List<UserResponse> userMapper(List<UserEntity> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        if (!users.isEmpty()) {
            users.forEach((user) -> {
                UserResponse userResponse = new UserResponse();
                userResponse.setId(user.getId());
                userResponse.setName(user.getName());
                userResponse.setLastName(user.getLastName());
                userResponse.setEmail(user.getEmail());
                userResponse.setUsername(user.getUsername());
                userResponses.add(userResponse);
            });
        }
        return userResponses;
    }
}
