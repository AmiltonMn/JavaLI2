package com.example.demo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.CitiesData;
import com.example.demo.model.City;
import com.example.demo.repositories.CitiesRepository;
import com.example.demo.services.CitiesService;

public class CitiesServiceImp implements CitiesService {

    private List<City> cities;

    @Autowired
    CitiesRepository repo;

    @Override
    public CitiesData findCity(String country) {

        cities = repo.findByCountry(country);

        return new CitiesData(cities);
    }

    @Override
    public CitiesData getAllCities() {
        cities = repo.findAll();

        return new CitiesData(cities);
    }
    
}
