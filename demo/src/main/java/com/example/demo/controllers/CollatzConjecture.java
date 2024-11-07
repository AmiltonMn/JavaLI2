package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CollatzData;

@RestController
@RequestMapping("/collatz")
@CrossOrigin(origins = { "http://localhost:5257" })
public class CollatzConjecture {
    

    @GetMapping("")
    public ResponseEntity<CollatzData> collatzFunction(Integer current, Integer step) {

        if (current < 0 || step < 0)
            return new ResponseEntity<>(new CollatzData(0, 0), HttpStatus.BAD_REQUEST);

        Integer new_current = 0;

        for (int i = 0; i < step; i++) {
            new_current = (current % 2 == 0) ? current / 2 : 3 * current + 1;
        }

        return new ResponseEntity<>(new CollatzData(new_current, step), HttpStatus.OK);
    }
}
