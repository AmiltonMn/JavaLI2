package com.example.demo.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dto.LoginData;
import com.example.demo.dto.TokenData;
import com.example.demo.dto.Token;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.JWTService;
import com.example.demo.services.LoginService;

public class LoginServiceImp implements LoginService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    JWTService<Token> jwtService;

    @Override
    public TokenData login(LoginData loginData) 
    {
        // Encripta a senha
        var encoder = new BCryptPasswordEncoder();

        if (loginData.login() == null || loginData.password() == null) 
        {
            TokenData data = new TokenData("Login and password are expected.", null);
            return data;
        }

        var users = userRepo.login(loginData.login());

        if (users.isEmpty()) 
        {
            TokenData data = new TokenData("The user do not exists.", null);
            return data;    
        }

        var user = users.get(0);

        if (!encoder.matches(loginData.password(), user.getPassword())) 
        {
            TokenData data = new TokenData("The password is incorrect.", null);
            return data;
        }

        Token token = new Token();
        token.setId(user.getId());
        token.setEmail(user.getEmail());

        // Aquie é feito o JWT
        var jwt = jwtService.get(token);

        return new TokenData("Logado com sucesso!.", jwt);
    }
    
}
