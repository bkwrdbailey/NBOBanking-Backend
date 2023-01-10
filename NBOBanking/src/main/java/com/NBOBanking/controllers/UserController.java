package com.NBOBanking.controllers;

import com.NBOBanking.models.User;
import com.NBOBanking.services.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/")
public class UserController {
    private IUserService _service;

    public UserController(IUserService service) {
        _service = service;
    }

    /* /Login?username={input one}&password={input two} */
    @GetMapping("login")
    @ResponseBody
    public User attemptToLogin(@RequestParam String username, @RequestParam String password) {
        return _service.verifyUserLogin(username, password);
    }

    /* /Signup (HTTP Request Body) */
    @PostMapping("signup")
    @ResponseBody
    public User attemptToSignUp(@RequestBody User newUser) {
        return _service.attemptNewUserRecord(newUser);
    }
}
