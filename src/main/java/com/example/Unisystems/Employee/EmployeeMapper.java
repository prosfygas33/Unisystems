package com.example.Unisystems.Employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    public EmployeeResponse mapEmployeeResponseFromEmployee(Employee employee){
        return new EmployeeResponse(
            employee.getId(),
            employee.getRecordNumber(),
            employee.getFirstName() + " " + employee.getLastName(),
                employee.getTelephoneNumber(),
                getWorkingPeriod(employee),
                employee.isStatus() ? Status.ACTIVE : Status.INACTIVE,
                employee.isContactType() ? "ACTIVE" : "EXTERNAL",
                employee.getPosition(),
                employee.getTasks(),
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

    private String getWorkingPeriod(Employee employee){
        String end;

        if(employee.getEndDate() == null)
            end = "Present";
        else {
            end = String.valueOf(employee.getEndDate());
        }
        return String.valueOf(employee.getStartDate()) + " - " + end;
    }
}
