package com.example.demo.services.implementations;

import java.util.ArrayList;

import com.example.demo.dto.CuritibaData;
import com.example.demo.services.CuritibaService;

public class CuritibaServiceImp implements CuritibaService {

    @Override
    public CuritibaData validateCPF(String CPF) {
        ArrayList<String> messages = new ArrayList<>();

        System.out.println(CPF);

        if (CPF == null) {
            messages.add("O CPF é nulo!");
            return new CuritibaData(messages);   
        }

        messages.add("A busca de CEP está fora do ar");

        Integer firstDigitSum = 0, placeholderValue = 0, firstDigit = 0, secondDigit = 0, secondDigitSum = 0;

        for (int i = 1; i < 9; i++) {
            placeholderValue = Integer.valueOf(CPF.charAt(i - 1)) * i;
            firstDigitSum += placeholderValue;
        }

        System.out.println(firstDigitSum);

        firstDigit = firstDigitSum % 11;

        System.out.println(firstDigit);

        if (firstDigit == 10)
            firstDigit = 0;

        if (!firstDigit.equals(Integer.valueOf(CPF.charAt(9)))) {
            System.out.println("Primeiro digito invalido");
            messages.add("CPF inválido!");
            return new CuritibaData(messages);
        }

        for (int i = 1; i < 10; i++) {
            placeholderValue = Integer.valueOf(CPF.charAt(i - 1)) * i;
            secondDigitSum += placeholderValue;
        }
        
        secondDigit = secondDigitSum / 11;

        if (secondDigit == 10)
            secondDigit = 0;

        if (!secondDigit.equals(Integer.valueOf(CPF.charAt(10)))) {
            System.out.println("Segundo digito invalido");
            messages.add("CPF inválido!");
            return new CuritibaData(messages);
        }

        messages.add("CPF Válido!");

        return new CuritibaData(messages);
    }
    
}
