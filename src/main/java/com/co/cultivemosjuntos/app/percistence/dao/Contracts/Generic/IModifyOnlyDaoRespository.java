package com.co.cultivemosjuntos.app.percistence.dao.Contracts.Generic;

public interface IModifyOnlyDaoRespository <T>{

    void save(T t);

    boolean update(T t);

    void delete(T t);
}
