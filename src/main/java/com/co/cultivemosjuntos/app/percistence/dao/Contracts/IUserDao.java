package com.co.cultivemosjuntos.app.percistence.dao.Contracts;

import com.co.cultivemosjuntos.app.percistence.dao.Contracts.Generic.IDaoRepository;
import com.co.cultivemosjuntos.app.percistence.models.Entities.UserEntity;


public interface IUserDao extends IDaoRepository<UserEntity> {

    boolean existsUserByUsername(String username);
    UserEntity getUserByUsername(String username);
}
