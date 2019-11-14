package com.example.Unisystems.mappers;

import com.example.Unisystems.model.Department;
import com.example.Unisystems.model.DepartmentResponse;
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
