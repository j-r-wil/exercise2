package com.citiworkshopexercises.exercise2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citiworkshopexercises.exercise2.dto.EmployeeDTO;

@Repository
public interface EmployeeRepository
    extends CrudRepository<EmployeeDTO, Long> {
}