package com.NBOBanking.repositories;

import com.NBOBanking.models.UserDB;

public interface IUserRepository {
    UserDB getUserRecord(String username);
    UserDB createUserRecord(UserDB newUser);
}
