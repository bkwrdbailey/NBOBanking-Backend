package com.NBOBanking.services;

import com.NBOBanking.models.User;

public interface IUserService {
    User verifyUserLogin(String username, String password);
    User attemptNewUserRecord(User newUser);
}
