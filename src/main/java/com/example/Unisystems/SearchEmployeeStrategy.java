package com.example.Unisystems;

import com.example.Unisystems.model.Employee;

import java.util.List;

public interface SearchEmployeeStrategy {

    List<Employee> execute(Long criteriaId, Iterable<Employee> allEmployees);
}
