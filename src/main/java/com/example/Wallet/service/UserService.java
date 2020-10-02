package com.example.Wallet.service;

import com.example.Wallet.request.LoginUser;
import com.example.Wallet.model.User;
import net.minidev.json.JSONObject;

public interface UserService {
    JSONObject registration(User user) throws Exception;
    JSONObject loginUser(LoginUser loginUser);
}
