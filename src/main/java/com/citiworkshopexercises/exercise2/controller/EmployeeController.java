package com.citiworkshopexercises.exercise2.controller;

import com.citiworkshopexercises.exercise2.entity.Employee;
import com.citiworkshopexercises.exercise2.service.EmployeeService;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired private EmployeeService employeeService;

    @PostMapping("/api/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping ("/api/employees/{id}")
    public Employee findEmployeeById(@PathVariable ("id") Long employeeID) {
        return employeeService.findEmployeeById(employeeID);
    }

    @GetMapping("/api/employees")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    @PutMapping("/api/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        return employeeService.updateEmployee(employee, employeeId);
    }
    
    @DeleteMapping("/api/employees/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.noContent().build();
    }
}