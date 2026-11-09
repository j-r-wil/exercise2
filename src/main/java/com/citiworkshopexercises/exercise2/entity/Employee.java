package com.citiworkshopexercises.exercise2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Employee name is mandatory")
    private String name;

    @NotBlank(message = "Employee role is mandatory")
    private String role;

    @NotNull(message = "Onboarding date is mandatory")
    @PastOrPresent (message = "Onboarding date cannot be in the future")
    private LocalDate onboardingDate;
}