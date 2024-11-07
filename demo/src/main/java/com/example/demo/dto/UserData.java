package com.example.demo.dto;

public record UserData(
    Long id,
    String username,
    String password,
    String email,
    String message
) {}