package com.NBOBanking.services;

import com.NBOBanking.models.User;

public interface IUserService {
    boolean verifyUserLogin(String username, String password);
    boolean attemptNewUserRecord(User newUser);
}
