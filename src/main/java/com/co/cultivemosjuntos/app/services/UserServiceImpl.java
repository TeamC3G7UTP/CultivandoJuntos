package com.co.cultivemosjuntos.app.services;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IUserDao;
import com.co.cultivemosjuntos.app.percistence.mappers.Security.UserMapper;
import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Business.Models.UserResponse;
import com.co.cultivemosjuntos.app.services.Contracts.IUserService;
import com.co.cultivemosjuntos.app.utils.Helpers.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void save(User user) {
        if (validateData(user)) {
            userDao.save(UserMapper.userMapper(user));
        }
    }

    @Override
    public void update(User user) {
        if (validateData(user)) {
            userDao.update(UserMapper.userMapper(user));
        }
    }

    @Override
    @Transactional
    public Optional<UserResponse> get(Long id) {
        return Optional.of(UserMapper.userMapper(userDao.get(id).orElse(null)));
    }

    @Override
    @Transactional
    public List<UserResponse> getAll() {
        return UserMapper.userMapper(userDao.getAll());
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return userDao.existsUserByUsername(username);
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        return UserMapper.userMapper(userDao.getUserByUsername(username));
    }

    private boolean validateData(User user) {
        return isValid(user.getName())
                && isValid(user.getLastName())
                && isValid(user.getPassword())
                && (isValid(user.getEmail()) && Validate.validateEmail(user.getEmail()));
    }

    private boolean isValid(String data) {
        return data.isEmpty() || data.isBlank();
    }


}
