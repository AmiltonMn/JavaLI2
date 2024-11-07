package com.example.demo.services;

import com.example.demo.dto.CitiesData;

public interface CitiesService {
    CitiesData findCity(String country);
    CitiesData getAllCities();
}
