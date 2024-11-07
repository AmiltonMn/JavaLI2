package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginData;
import com.example.demo.dto.TokenData;
import com.example.demo.services.LoginService;

@RestController
public class UserController {

    @Autowired
    LoginService service;
    
    @PostMapping("/login")
    public TokenData login(@RequestBody LoginData data) {

        return service.login(data);
    }
}
