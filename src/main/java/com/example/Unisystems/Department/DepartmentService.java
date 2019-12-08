package com.example.Unisystems.Department;

import com.example.Unisystems.Department.DepartmentMapper;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Department.DepartmentResponse;
import com.example.Unisystems.Department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public List<DepartmentResponse> getDepartments(){
        Iterable<Department> retrievedDepartments = departmentRepository.findAll();
        List<DepartmentResponse> departments = new ArrayList<>();

        for ( Department department : retrievedDepartments ){
            departments.add(departmentMapper.mapDepartmentResponseFromDepartment(department));
        }

        return departments;
    }
}
