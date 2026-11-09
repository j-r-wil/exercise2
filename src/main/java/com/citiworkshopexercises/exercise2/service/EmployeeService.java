package com.citiworkshopexercises.exercise2.service;
import com.citiworkshopexercises.exercise2.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> fetchEmployeeList();

    Employee findEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployeeById(Long id);
}