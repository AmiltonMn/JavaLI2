package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.City;

public record CitiesData(
    List<City> cities
) {}
