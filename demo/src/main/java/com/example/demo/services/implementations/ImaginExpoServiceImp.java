package com.example.demo.services.implementations;

import com.example.demo.dto.ImaginaryExpoData;
import com.example.demo.services.ImaginaryExpoService;

public class ImaginExpoServiceImp implements ImaginaryExpoService {

    @Override
    public ImaginaryExpoData calcImaginaryExpo(Integer A, Integer b) {
        Double Re = A * Math.sin(b);
        Double Im = A * Math.cos(b);

        return new ImaginaryExpoData(Re, Im);
    }
    
}
