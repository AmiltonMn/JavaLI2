package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.Token;
import com.example.demo.services.CitiesService;
import com.example.demo.services.CuritibaService;
import com.example.demo.services.ImaginaryExpoService;
import com.example.demo.services.JWTService;
import com.example.demo.services.LoginService;
import com.example.demo.services.PasswordEncoderService;
import com.example.demo.services.UserService;
import com.example.demo.services.implementations.BcryptPasswordEncoderService;
import com.example.demo.services.implementations.CitiesServiceImp;
import com.example.demo.services.implementations.CuritibaServiceImp;
import com.example.demo.services.implementations.ImaginExpoServiceImp;
import com.example.demo.services.implementations.LoginServiceImp;
import com.example.demo.services.implementations.ReverseServiceImp;
import com.example.demo.services.implementations.UserServiceImp;
import com.example.demo.services.implementations.DefaultJWTService;
import com.example.demo.services.ReverseService;

@Configuration
public class DependencyConfiguration {

    @Bean
    public ReverseService reverseService() {
        return new ReverseServiceImp();
    }

    @Bean
    public ImaginaryExpoService expoService() {
        return new ImaginExpoServiceImp();
    }

    @Bean
    public CuritibaService curitibaService() {
        return new CuritibaServiceImp();
    }

    @Bean
    public CitiesService citiesService() {
        return new CitiesServiceImp();
    }

    @Bean
    public UserService newUserService() {
        return new UserServiceImp();
    }

    @Bean
    public PasswordEncoderService encoderService() {
        return new BcryptPasswordEncoderService();
    }

    @Bean
    public JWTService<Token> jwtService() {
        return new DefaultJWTService();
    }

    @Bean
    public LoginService loginService() {
        return new LoginServiceImp();
    }
}
