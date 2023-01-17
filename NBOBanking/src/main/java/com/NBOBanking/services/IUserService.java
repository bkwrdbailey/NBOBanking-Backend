package com.NBOBanking.services;

import com.NBOBanking.DTO.UserDTO;

public interface IUserService {
    UserDTO verifyUserLogin(String username, String password);
    UserDTO attemptNewUserRecord(UserDTO newUser);
}
