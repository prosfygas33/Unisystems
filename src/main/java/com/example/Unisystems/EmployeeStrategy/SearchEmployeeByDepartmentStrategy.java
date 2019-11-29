package com.example.Unisystems.EmployeeStrategy;

import com.example.Unisystems.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class SearchEmployeeByDepartmentStrategy implements SearchEmployeeStrategy {
    @Override
    public List<Employee> execute(Long criteriaId, Iterable<Employee> allEmployees) {

        List<Employee> employees = new ArrayList<>();

        for( Employee employee : allEmployees ) {
            if ( employee.getUnit().getDepartment().getId() == criteriaId ){
                employees.add(employee);
            }
        }

        return employees;
    }
}
