package com.citiworkshopexercises.exercise2.service;
import java.util.List;

import com.citiworkshopexercises.exercise2.dto.EmployeeDTO;

public interface EmployeeService {
    List<EmployeeDTO> fetchEmployeeList();

    EmployeeDTO findEmployeeById(Long id);

    EmployeeDTO saveEmployee(EmployeeDTO employee);

    EmployeeDTO updateEmployee(EmployeeDTO employee, Long id);

    void deleteEmployeeById(Long id);
}