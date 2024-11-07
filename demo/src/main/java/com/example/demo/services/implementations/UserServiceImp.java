package com.example.demo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dto.LoginData;
import com.example.demo.dto.PasswordUpdateData;
import com.example.demo.dto.TokenData;
import com.example.demo.dto.UserData;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

public class UserServiceImp implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public TokenData login(LoginData data) 
    {
        return null;
    }

    @Override
    public String createUser(UserData data) 
    {
        var encoder = new BCryptPasswordEncoder();

        User newUser = new User();
        
        if (verifyEmptyFieldsRegister(data))
            return "Preencha todos os campos!";

        if (verifyFieldsLength(data.email(), data.username()))
            return "Os campos precisam ter no mínimo 4 caracteres!";

        if (verifyEmail(data.email()))
            return "E-mail com formato inválido!";

        if (verifyAvailableEmail(data.email()))
            return "O E-mail já está em uso!";

        if (verifyAvailableUsername(data.username()))
            return "O nome de usuário já está em uso!";

        // if (verifyPasswordLength(data.password()))
        //     return "A senha precisa ter no mínimo 8 caracteres!";
        
        // if (!verifyNumberInPassword(data.password()))
        //     return "A senha precisa possuir pelo menos um número!";
        
        // if (!verifyLowerCaseInPassword(data.password()))
        //     return "A senha precisa possuir pelo menos uma letra minúscula!";

        // if (!verifyUpperCaseInPassword(data.password()))
        //     return "A senha precisa possuir pelo menos uma letra maiúscula!";

        newUser.setUsername(data.username());
        newUser.setPassword(encoder.encode(data.password()));
        newUser.setEmail(data.email());

        repo.save(newUser);
        
        return "Usuário criado com sucesso!";
    }       
    
    @Override
    public String changePassword(PasswordUpdateData data) 
    {

        if (verifyEmptyFieldsChangePass(data))
            return "Por favor preencha todos os campos!";
        
        if (!verifyAvailableUsername(data.username()))
            return "Usuário não encontrado!";

        List<User> users = repo.findByUsername(data.username());

        System.out.println(users.get(0).getPassword());
        System.out.println(data.password());
        
        if (!comparePassword(data.password(), users.get(0).getPassword()))
            return "A sua senha antiga está errada!";

        if (verifyPasswordLength(data.newPassword()))
            return "A senha precisa ter no mínimo 8 caracteres!";
        
        if (!verifyNumberInPassword(data.newPassword()))
            return "A senha precisa possuir pelo menos um número!";
        
        if (!verifyLowerCaseInPassword(data.newPassword()))
            return "A senha precisa possuir pelo menos uma letra minúscula!";

        if (!verifyUpperCaseInPassword(data.newPassword()))
            return "A senha precisa possuir pelo menos uma letra maiúscula!";
        
        if (!confirmPassword(data.newPassword(), data.repeatPassword()))
            return "As novas senhas precisam ser iguais";
        
        User user = users.get(0);

        user.setPassword(data.newPassword());

        repo.save(user);

        return "Senha alterada com sucesso!";
    }

    public Boolean confirmPassword(String pass1, String pass2) 
    {
        if (pass1.contentEquals(pass2))
            return true;
        
        return false;
    }

    public Boolean comparePassword(String password, String oldPassword) 
    {
        if (password.contentEquals(oldPassword))
            return true;

        return false;
    }

    public Boolean verifyEmptyFieldsChangePass(PasswordUpdateData data) 
    {
    if (data.newPassword().equals("") || data.repeatPassword().equals("")|| data.password().equals("") || data.username().equals("")) {
            return true;
        }

        return false;
    }

    public Boolean verifyEmptyFieldsRegister(UserData data) 
    {
        if (data.email().equals("") || data.password().equals("") || data.username().equals("")) {
            return true;
        }

        return false;
    }

    public Boolean verifyFieldsLength(String email, String username) 
    {
        if (email.length() < 4 || username.length() < 4) {
            return true;
        }
        
        return false;
    }

    public Boolean verifyEmail(String email) 
    {
        Integer position = email.indexOf("@");

        if (position > 0 && email.substring(position).contains(".")) {
            return false;
        }

        return true;
    }

    public Boolean verifyAvailableEmail(String email) 
    {
        List<User> emails = repo.findByEmail(email);
    
        if (emails.size() <= 0) {
            return false;
        }

        return true;
    }

    public Boolean verifyAvailableUsername(String username) 
    {
        List<User> usernames = repo.findByUsername(username);
    
        if (usernames.size() <= 0) {
            return false;
        }

        return true;
    }

    public Boolean verifyPasswordLength(String password) 
    {
        if (password.length() < 8) {
            return true;
        }

        return false;
    }

    public Boolean verifyNumberInPassword(String password) 
    {
        if (password.matches(".*[0-9].*"))
            return true;
        
        return false;
    }

    public Boolean verifyLowerCaseInPassword(String password) 
    {
        if (password.matches(".*[a-z].*"))
            return true;
        
        return false;
    }

    public Boolean verifyUpperCaseInPassword(String password) 
    {
        if (password.matches(".*[A-Z].*"))
            return true;

        return false;
    }
}
