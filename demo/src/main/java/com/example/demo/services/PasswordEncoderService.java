package com.example.demo.services;

public interface PasswordEncoderService {
    String encode(String password);
    Boolean matches(String storagedPass, String inputPass);
}
