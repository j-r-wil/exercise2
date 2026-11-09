package com.citiworkshopexercises.exercise2.service;

import com.citiworkshopexercises.exercise2.entity.Employee;
import com.citiworkshopexercises.exercise2.repository.EmployeeRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.util.List;
import java.util.Set;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor 
@Transactional 
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private final Validator validator;

    @Override 
    @Transactional(readOnly = true)
    public List<Employee> fetchEmployeeList() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
            .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + employeeId));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Employee> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId)
    {
        if (!employeeRepository.existsById(employeeId)) {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }

        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Employee> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
        }
        employeeRepository.deleteById(employeeId);
    }
}