package com.example.Wallet.controller;

import com.example.Wallet.request.LoginUser;
import com.example.Wallet.model.User;
import com.example.Wallet.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    @PostMapping(path = "/registration",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject registerUserAccount(@RequestBody User user) throws Exception {
        return userService.registration(user);
    }

    @PostMapping(path = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject loginAccount(@RequestBody LoginUser loginUser)
    {
        return userService.loginUser(loginUser);
    }
}
