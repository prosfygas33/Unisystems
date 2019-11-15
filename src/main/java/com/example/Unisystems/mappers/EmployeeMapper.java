package com.example.Unisystems.mappers;

import com.example.Unisystems.model.Employee;
import com.example.Unisystems.model.EmployeeResponse;
import com.example.Unisystems.model.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    public EmployeeResponse mapEmployeeResponseFromEmployee(Employee employee){
        return new EmployeeResponse(
                employee.getUnit().getId(),
                employee.getId(),
                employee.getFirstname() + " " + employee.getLastname(),
                employee.getTelephoneNumber(),
                employee.getStartDate() + " - " + employee.getEndDate(),
                employee.isStatus() ? Status.ACTIVE : Status.INACTIVE,
                employee.isContactType() ? "ACTIVE" : "EXTERNAL",
                employee.getPosition(),
                employee.getUnit().getName()
        );
    }

    public List<EmployeeResponse> mapAllEmployees(List<Employee> employees){
        List<EmployeeResponse> employeesResponse = new ArrayList<>();

        for ( Employee employee : employees ){
            employeesResponse.add(mapEmployeeResponseFromEmployee(employee));
        }
        return employeesResponse;
    }
}
