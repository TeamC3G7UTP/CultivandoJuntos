package com.co.cultivemosjuntos.app.services.Contracts;

import com.co.cultivemosjuntos.app.services.Business.Models.UserLogin;

public interface IAuthenticateService {

    boolean login(UserLogin userLogin);

    boolean requestRecovery(UserLogin userLogin);

    boolean recoveryPassword(UserLogin userLogin);
}
