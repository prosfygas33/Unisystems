package com.example.Unisystems;

import com.example.Unisystems.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class SearchEmployeeByUnitStrategy implements SearchEmployeeStrategy {

    @Override
    public List<Employee> execute(Long criteriaId, Iterable<Employee> allEmployees) {

        List<Employee> employees = new ArrayList<>();

        for( Employee employee : allEmployees ) {
            if ( employee.getUnit().getId() == criteriaId ){
                employees.add(employee);
            }
        }

        return employees;
    }
}
