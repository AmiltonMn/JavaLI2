package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserData;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/create")
public class NewUserController {

    @Autowired
    UserService newUserService;

    @PostMapping
    public String createUser(@RequestBody UserData data) {
        
        String message = newUserService.createUser(data);

        return message;
    }
    
}
