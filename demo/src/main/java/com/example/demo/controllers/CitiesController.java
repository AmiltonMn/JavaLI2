package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CitiesData;
import com.example.demo.services.CitiesService;

@RestController
@RequestMapping("/cities")
public class CitiesController {
    
    @Autowired
    CitiesService service;

    @GetMapping("/")
    public CitiesData getAllCities() {

        CitiesData data = service.getAllCities();

        return data;
    }

    @GetMapping("/{country}")
    public CitiesData getByCountry(@PathVariable String country) {

        CitiesData data = service.findCity(country);

        return data;
    }
}
