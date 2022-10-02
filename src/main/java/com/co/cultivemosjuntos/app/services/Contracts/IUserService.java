package com.co.cultivemosjuntos.app.services.Contracts;

import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Business.Models.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    boolean save(User user);

    boolean update(User user);

    Optional<UserResponse> get(Long id);

    List<UserResponse> getAll();

    boolean existsUserByUsername(String username);

    UserResponse getUserByUsername(String username);

    boolean updateState(Long id);

    boolean firstAdmission(Long id);


}
