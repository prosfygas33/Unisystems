package com.example.Unisystems.Employee;

import java.util.List;

public class GetAllEmployeeIds {

    private List<EmployeeId> employeeIds;

    public GetAllEmployeeIds() {
    }

    public GetAllEmployeeIds(List<EmployeeId> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public List<EmployeeId> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<EmployeeId> employeeIds) {
        this.employeeIds = employeeIds;
    }
}
