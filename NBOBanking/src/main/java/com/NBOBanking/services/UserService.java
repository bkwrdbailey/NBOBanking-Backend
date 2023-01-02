package com.NBOBanking.services;

import com.NBOBanking.models.User;

public class UserService implements IUserService{
    public UserService() {

    }

    @Override
    public boolean verifyUserLogin(String username, String password) {
        return false;
    }

    @Override
    public boolean attemptNewUserRecord(User newUser) {
        return false;
    }
}
