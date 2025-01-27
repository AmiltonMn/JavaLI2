package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PasswordUpdateData;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/changepassword")
public class ChangePassController {

    @Autowired
    UserService service;
    
    @PatchMapping("")
    public String changePassword(@RequestBody PasswordUpdateData data) 
    {
        System.out.println("Recebemos esses dados: " + data);

        String message = service.changePassword(data);

        return message;
    }
}
