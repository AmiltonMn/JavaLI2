package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CuritibaData;
import com.example.demo.services.CuritibaService;

@RestController
@RequestMapping("/curitiba")
public class CuritibaController 
{

    @Autowired
    CuritibaService service;

    @GetMapping("/{CPF}")
    public CuritibaData cpfValidate(@PathVariable String CPF) {

        CuritibaData data = service.validateCPF(CPF);

        return data;
    }
}