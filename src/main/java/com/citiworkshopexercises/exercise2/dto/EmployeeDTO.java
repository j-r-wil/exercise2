package com.citiworkshopexercises.exercise2.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table (name = "employees")
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "name", nullable = false)
    @NotBlank(message = "Employee name is mandatory")
    private String name;

    @Column (name = "role", nullable = false)
    @NotBlank(message = "Employee role is mandatory")
    private String role;

    @Column (name = "onboarding_date", nullable = false)
    @NotBlank(message = "Onboarding date is mandatory")
    @PastOrPresent (message = "Onboarding date cannot be in the future")
    private LocalDate onboardingDate;
}