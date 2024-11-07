package com.example.demo.services.implementations;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.demo.dto.PalindromeData;
import com.example.demo.services.ReverseService;

public class ReverseServiceImp implements ReverseService {

    @Override
    public PalindromeData reverseWord(String word) {
       Boolean isPalindrome = false;
        
        ArrayList<String> reversedLetters = new ArrayList<>();
        String reversedWord = "";

        for (int i = word.length(); i > 0; i--)
            reversedLetters.add(String.valueOf(word.charAt(i - 1)));

        reversedWord = reversedLetters.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());

        if (reversedWord.equals(word))
            isPalindrome = true;

        System.out.println(reversedWord);

        return new PalindromeData(word, reversedWord, isPalindrome);
    }
    
}
