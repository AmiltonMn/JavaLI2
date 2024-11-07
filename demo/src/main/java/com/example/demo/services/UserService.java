package com.example.demo.services;

import com.example.demo.dto.LoginData;
import com.example.demo.dto.PasswordUpdateData;
import com.example.demo.dto.TokenData;
import com.example.demo.dto.UserData;

public interface UserService {
    String createUser(UserData data);
    String changePassword(PasswordUpdateData data);
    TokenData login(LoginData data);
}