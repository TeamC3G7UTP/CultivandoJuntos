package com.co.cultivemosjuntos.app.services;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IUserDao;
import com.co.cultivemosjuntos.app.percistence.mappers.Security.UserMapper;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.User;
import com.co.cultivemosjuntos.app.services.Business.Models.UserResponse;
import com.co.cultivemosjuntos.app.services.Contracts.IUserService;
import com.co.cultivemosjuntos.app.utils.Helpers.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public boolean save(User user) {
        boolean response = false;
        if (!validateData(user)) {
            user.setPassword(encoder.encode(user.getPassword()));
            userDao.save(UserMapper.userMapper(user));
            response = true;
        }

        return response;
    }

    @Override
    @Transactional
    public boolean update(User user) {
        boolean response = false;
        if (!validateData(user)) {
            UserEntity userTemp = userDao.getUserByUsername(user.getUsername());
            if (userTemp != null) {
                user.setPassword(encoder.encode(user.getPassword()));
                response = userDao.update(UserMapper.userUpdateMapper(user, userTemp));
            }
        }
        return response;
    }

    @Override
    @Transactional
    public Optional<UserResponse> get(Long id) {
        Optional<UserResponse> response = null;
        if (!isValidId(id)) {
            response = Optional.ofNullable(UserMapper.userMapper(userDao.get(id).orElse(null)));
        }
        return response;
    }

    @Override
    @Transactional
    public List<UserResponse> getAll() {
        return UserMapper.userMapper(userDao.getAll());
    }

    @Override
    @Transactional
    public boolean existsUserByUsername(String username) {
        if (!isValid(username)) {
            return userDao.existsUserByUsername(username);
        }
        return false;
    }

    @Override
    @Transactional
    public UserResponse getUserByUsername(String username) {
        if (!isValid(username)) {
            return UserMapper.userMapper(userDao.getUserByUsername(username));
        }
        return null;
    }

    @Override
    @Transactional
    public boolean updateState(Long id) {
        boolean response = false;
        var user = userDao.get(id);
        if (user.isPresent() && !user.isEmpty()) {
            UserEntity userEntity = user.get();
            userEntity.setFirstAdmission(false);
            response = userDao.update(userEntity);
        }
        return response;
    }

    @Override
    @Transactional
    public boolean firstAdmission(Long id) {
        boolean result = false;
        if (!isValidId(id)) {
            UserEntity userEntity = userDao.get(id).orElse(null);
            if (userEntity != null) {
                result = userEntity.isFirstAdmission();
            }
        }
        return result;
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

    private boolean isValidId(Long id) {
        return Objects.isNull(id) || id < 0;
    }


}
