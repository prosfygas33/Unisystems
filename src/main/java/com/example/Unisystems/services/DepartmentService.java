package com.example.Unisystems.services;

import com.example.Unisystems.mappers.DepartmentMapper;
import com.example.Unisystems.model.Department;
import com.example.Unisystems.model.DepartmentResponse;
import com.example.Unisystems.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentMapper departmentMapper;

    public List<DepartmentResponse> getDepartments(){
        Iterable<Department> retrievedDepartments = departmentRepository.findAll();
        List<DepartmentResponse> departments = new ArrayList<>();

        for ( Department department : retrievedDepartments ){
            departments.add(departmentMapper.mapDepartmentResponseFromDepartment(department));
        }

        return departments;
    }
}
