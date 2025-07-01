package com.example.spring_security_jwt.controller.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
