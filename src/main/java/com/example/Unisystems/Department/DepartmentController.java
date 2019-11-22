package com.example.Unisystems.Department;

import com.example.Unisystems.Department.GetAllDepartments;
import com.example.Unisystems.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/Departments")
    public ResponseEntity getAllDepartments(){
        return new ResponseEntity(
                new GetAllDepartments(departmentService.getDepartments()),
                null,
                HttpStatus.OK
        );
    }
}
