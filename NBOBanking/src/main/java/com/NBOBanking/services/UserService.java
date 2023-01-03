package com.NBOBanking.services;

import com.NBOBanking.models.User;
import com.NBOBanking.models.UserDB;
import com.NBOBanking.repositories.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class UserService implements IUserService {
    private UserRepository _repo;
    public UserService(UserRepository repo) {
        _repo = repo;
    }

    @Override
    public boolean verifyUserLogin(String username, String password) {
        // Check if user exists in database

        return false;
    }

    @Override
    public boolean attemptNewUserRecord(User newUser) {
        // Check if user already exists in database
        UserDB checkUser = _repo.getUserRecord(newUser.username);
        // Add user to database
        if(checkUser != null)
        {
            UserDB newUserDB = new UserDB();
            newUserDB.username = newUser.username;
            newUserDB.salt = saltJar();

            if(hashFactory(newUser.password + newUserDB.salt) == "failed") {
                return false;
            } else {
                newUserDB.password = hashFactory(newUser.password + newUserDB.salt);
                newUserDB.email = newUser.email;
                newUserDB.firstname = newUser.firstname;
                newUserDB.lastname = newUser.lastname;
            }

            return _repo.createUserRecord(newUserDB);
        }

        return false;
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
