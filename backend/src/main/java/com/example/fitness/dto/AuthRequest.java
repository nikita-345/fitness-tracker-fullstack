package com.example.fitness.dto;
import jakarta.validation.constraints.*;
public record AuthRequest(@Email @NotBlank String email,@NotBlank String password) {}