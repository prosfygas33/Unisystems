package com.example.Unisystems.Department;

import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Department.DepartmentResponse;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentResponse mapDepartmentResponseFromDepartment(Department department){
        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getBusinessUnit()
        );
    }
}
