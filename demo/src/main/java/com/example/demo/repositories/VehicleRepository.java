package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vehicle;

/* 
    Aqui o repositório herda da classe padrão do Java para repositorios de models.
    Usamos os parâmetros "Vehicle" e "Long" para o JpaRepository pois são o tipo da Model e o tipo do ID do model, respectivamente.
*/ 

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    List<Vehicle> findByType(String type);
}
