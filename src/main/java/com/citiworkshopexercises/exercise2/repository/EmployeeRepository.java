package com.citiworkshopexercises.exercise2.repository;

import com.citiworkshopexercises.exercise2.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface extending CrudRepository
public interface EmployeeRepository
    extends CrudRepository<Employee, Long> {
}