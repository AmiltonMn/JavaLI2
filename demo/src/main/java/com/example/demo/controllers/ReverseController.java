package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PalindromeData;
import com.example.demo.services.ReverseService;


@RestController
@RequestMapping("/reverse")
public class ReverseController {

    @Autowired
    ReverseService reverseService;
    
    @GetMapping("/{word}")
    @CrossOrigin(origins = { "http://localhost:5257" })
    public PalindromeData reverseWord(@PathVariable String word) {

        PalindromeData data = reverseService.reverseWord(word);

        return data;
    }
}
