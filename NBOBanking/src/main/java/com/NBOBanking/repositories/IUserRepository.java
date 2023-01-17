package com.NBOBanking.repositories;

import com.NBOBanking.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserRepository {
    User getUserRecord(String username);
    User createUserRecord(User newUser);
}
