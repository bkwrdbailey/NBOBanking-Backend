package com.NBOBanking.repositories;

import com.NBOBanking.models.UserDB;

public class UserRepository {
    public UserRepository() {

    }

    public UserDB getUserRecord(String username) {
        return new UserDB();
    }

    public boolean createUserRecord(UserDB newUser) {
        return false;
    }

}
