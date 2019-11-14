package com.example.Unisystems.model;

import java.util.List;

public class GetAllDepartments {

    private List<DepartmentResponse> departments;

    public GetAllDepartments(List<DepartmentResponse> departments) {
        this.departments = departments;
    }

    public List<DepartmentResponse> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentResponse> departments) {
        this.departments = departments;
    }
}
