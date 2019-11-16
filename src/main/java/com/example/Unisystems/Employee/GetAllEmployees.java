package com.example.Unisystems.Employee;

import java.util.List;

public class GetAllEmployees {

    private List<EmployeeResponse> employees;

    public GetAllEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }

    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }
}
