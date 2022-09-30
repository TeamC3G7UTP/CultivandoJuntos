package com.co.cultivemosjuntos.app.services;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.IUserDao;
import com.co.cultivemosjuntos.app.percistence.mappers.Security.LoginMapper;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;
import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;
import com.co.cultivemosjuntos.app.services.Contracts.IAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthenticateServiceImpl implements IAuthenticateService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public boolean login(UserLogin userLogin) {
        boolean response = false;
        UserLogin userTemp;
        if (!validateData(userLogin)) {
            if (userDao.existsUserByUsername(userLogin.getUsername())) {
                userTemp = LoginMapper.userMapper(userDao.getUserByUsername(userLogin.getUsername()));
                response = encoder.matches(userLogin.getPassword(), userTemp.getPassword());
            }
        }
        return response;
    }

    @Override
    @Transactional
    public boolean requestRecovery(UserLogin userLogin) {
        boolean response = false;
        if (!validateData(userLogin)) {
            response = userDao.existsUserByUsername(userLogin.getUsername());
        }
        return response;
    }

    @Override
    @Transactional
    public boolean recoveryPassword(UserLogin userLogin) {
        boolean response = false;
        UserEntity userEntity;
        if (!validateData(userLogin)) {
            userEntity = userDao.getUserByUsername(userLogin.getUsername());
            if (userEntity != null) {
                userEntity.setPassword(encoder.encode(userLogin.getPassword()));
                response = userDao.update(userEntity);
            }
        }
        return response;
    }

    private boolean validateData(UserLogin user) {
        return isValid(user.getPassword())
                && isValid(user.getUsername());
    }

    private boolean isValid(String data) {
        return data.isEmpty() || data.isBlank();
    }
}
