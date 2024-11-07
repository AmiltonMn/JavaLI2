package com.example.demo.services.implementations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.services.PasswordEncoderService;

public class BcryptPasswordEncoderService implements PasswordEncoderService {

    @Override
    public String encode(String password)
    {
        var encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    public Boolean matches(String storagedPass, String inputPass) {
        var encoder = new BCryptPasswordEncoder();

        if (encoder.matches(storagedPass, inputPass))
            return true;

        return false;
    }
}
