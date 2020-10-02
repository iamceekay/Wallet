package com.example.Wallet.web.dto;

import com.example.Wallet.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserRegistrationControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    void registerUserAccount() throws Exception {
       /* Map<String, String> dataMap = new HashMap<>();
        dataMap.put("firstName","Ck ");
        dataMap.put("lastName","Khamari");
        dataMap.put("phoneNumber","9900065441");
        dataMap.put("emailid","chandrakant.kh13@gmail.com");
        dataMap.put("password","abcdef");*/
        User user= new User("Ck","khamari","9900065441","chandrakant.kh13@gmail.com","abcde");
        String validJson = new GsonBuilder().create().toJson(user);
        mvc.perform(post("/registration").content(user.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}