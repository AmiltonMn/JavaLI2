package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ImaginaryExpoData;
import com.example.demo.services.ImaginaryExpoService;

@RestController
@RequestMapping("/imaexp")
@CrossOrigin(origins = { "http://localhost:5257" })
public class ImaginaryExponential {
    
    @Autowired
    ImaginaryExpoService service;
    
    @GetMapping("")
    @CrossOrigin(origins = { "http://localhost:5257" })
    public ImaginaryExpoData calcImaginaryExpo(Integer A, Integer b) {
        ImaginaryExpoData data = service.calcImaginaryExpo(A, b);

        return data;
    }
}
