package com.NBOBanking.repositories;

import com.NBOBanking.models.UserDB;
import org.springframework.stereotype.Service;

@Service
public interface IUserRepository {
    UserDB getUserRecord(String username);
    UserDB createUserRecord(UserDB newUser);
}
