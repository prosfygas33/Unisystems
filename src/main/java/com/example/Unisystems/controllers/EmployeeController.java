package com.example.Unisystems.controllers;

import com.example.Unisystems.model.EmployeeResponse;
import com.example.Unisystems.model.GenericResponse;
import com.example.Unisystems.model.Error;
import com.example.Unisystems.model.GetAllEmployees;
import com.example.Unisystems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public GetAllEmployees getAllEmployees(){
        return new GetAllEmployees(employeeService.getEmployees());
    }



    @GetMapping("{searchCriteria}/{id}")
    public ResponseEntity getEmployeesById(@PathVariable String searchCriteria, @PathVariable long id) {
        if (!searchCriteria.equals("employee"))
            return new ResponseEntity(
                    new Error(0, "wrong id", "There is no employee with this id"),
                    null,
                    HttpStatus.BAD_REQUEST
            );
        GenericResponse<List<EmployeeResponse>> response = employeeService.getEmployeesById(searchCriteria, id);
        if (response.getError() != null)
            return new ResponseEntity(
                    response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST
            );

        return new ResponseEntity(
                new GetAllEmployees(response.getData()),
                null,
                HttpStatus.OK);

     }

    }

