package com.NBOBanking.controllers;

import com.NBOBanking.models.User;
import com.NBOBanking.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private IUserService _service;

    public UserController(IUserService service) {
        _service = service;
    }

    /* /Login?username={input one}&password={input two} */
    @GetMapping("Login")
    @ResponseBody
    public User attemptToLogin(@RequestParam String username, @RequestParam String password) {
        return _service.verifyUserLogin(username, password);
    }

    /* /Signup (HTTP Request Body) */
    @PostMapping("Signup")
    @ResponseBody
    public User attemptToSignUp(@RequestBody User newUser) {
        return _service.attemptNewUserRecord(newUser);
    }
}
