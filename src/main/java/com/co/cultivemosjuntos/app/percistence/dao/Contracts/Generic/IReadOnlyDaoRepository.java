package com.co.cultivemosjuntos.app.percistence.dao.Contracts.Generic;


import java.util.List;
import java.util.Optional;

public interface IReadOnlyDaoRepository <T>{

    Optional<T> get (Long id);

    List<T> getAll();
}
