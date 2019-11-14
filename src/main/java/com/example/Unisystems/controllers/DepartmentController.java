package com.example.Unisystems.controllers;

import com.example.Unisystems.model.GetAllDepartments;
import com.example.Unisystems.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/Departments")
    public GetAllDepartments getAllDepartments(){
        return new GetAllDepartments(departmentService.getDepartments());
    }
}
