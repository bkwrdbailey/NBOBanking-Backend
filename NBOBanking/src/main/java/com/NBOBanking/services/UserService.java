package com.NBOBanking.services;

import com.NBOBanking.DTO.UserDTO;
import com.NBOBanking.Entities.User;
import com.NBOBanking.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Service
public class UserService implements IUserService {
    private final IUserRepository _repo;

    @Autowired
    public UserService(IUserRepository repo) {
        _repo = repo;
    }

    @Override
    public UserDTO verifyUserLogin(String username, String password) {
        // Check if user exists in database
        User checkUser = _repo.getUserRecord(username);

        if(checkUser != null) {
            if(hashFactory(password + checkUser.salt) == checkUser.password) {
                UserDTO userData = new UserDTO(checkUser.user_id, checkUser.firstname, checkUser.lastname, checkUser.username, checkUser.password, checkUser.email);
                return userData;
            }
        }

        return new UserDTO();
    }

    @Override
    public UserDTO attemptNewUserRecord(UserDTO newUser) {
        // Check if user already exists in database
        User checkUser = _repo.getUserRecord(newUser.username);

        // Add user to database
        if(checkUser == null)
        {
            User newUserDB = new User();
            newUserDB.username = newUser.username;
            newUserDB.salt = saltJar();

            if(hashFactory(newUser.password + newUserDB.salt) == "failed") {
                return new UserDTO();
            } else {
                newUserDB.password = hashFactory(newUser.password + newUserDB.salt);
                newUserDB.email = newUser.email;
                newUserDB.firstname = newUser.firstname;
                newUserDB.lastname = newUser.lastname;
            }

            checkUser = _repo.createUserRecord(newUserDB);

            newUser.user_id = checkUser.user_id;
            newUser.password = "";

            return newUser;
        }

        return new UserDTO();
    }

    private String saltJar() {
        String salt = "";
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();

        int saltLimit = rand.nextInt(6, 12);

        for(int i = 0; i <= saltLimit; i++) {
            int index = rand.nextInt(alphanumeric.length());
            salt += alphanumeric.toCharArray()[index];
        }

        return salt;
    }

    private String hashFactory(String saltedPassword) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(saltedPassword.getBytes());
            byte[] digest = md.digest();
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < digest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }

            return hexString.toString();

        } catch(NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }

        return "failed";
    }
}
