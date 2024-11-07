package com.example.demo.services;

import com.example.demo.dto.LoginData;
import com.example.demo.dto.TokenData;

public interface LoginService {
    TokenData login(LoginData loginData);
}
