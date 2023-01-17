package com.NBOBanking.controllers;

import com.NBOBanking.DTO.UserDTO;
import com.NBOBanking.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/user/")
public class UserController {
    private final IUserService _service;

    @Autowired
    public UserController(IUserService service) {
        _service = service;
    }

    /* /Login?username={input one}&password={input two} */
    @GetMapping("login")
    @ResponseBody
    public UserDTO attemptToLogin(@RequestParam String username, @RequestParam String password) {
        return _service.verifyUserLogin(username, password);
    }

    /* /Signup (HTTP Request Body) */
    @PostMapping("signup")
    @ResponseBody
    public UserDTO attemptToSignUp(@RequestBody UserDTO newUser) {
        return _service.attemptNewUserRecord(newUser);
    }
}
