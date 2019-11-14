package com.example.Unisystems.controllers;

import com.example.Unisystems.model.EmployeeResponse;
import com.example.Unisystems.model.GenericResponse;
import com.example.Unisystems.model.Error;
import com.example.Unisystems.model.GetAllEmployees;
import com.example.Unisystems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    ///// GET /////
    @GetMapping("/employees")
    public GetAllEmployees getAllEmployees(){
        return new GetAllEmployees(service.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public GetAllEmployees getAllEmployeesById(@PathVariable Long id){
        return new GetAllEmployees(service.getAllEmployeesById(id));
    }
/*
    @GetMapping("/EmployeesByCriteria/{searchCriteria}/{id}")
    public GetAllEmployeesResponse getAllEmployeesByCriteria(@PathVariable("searchCriteria") String searchCriteria, @PathVariable("id") Long id){
            return new GetAllEmployeesResponse(service.getAllEmployeesByCriteria(searchCriteria, id));
    }
 */

    @GetMapping("/employeesByCriteria/{searchCriteria}/{criteriaId}")
    public ResponseEntity getAllEmployeesByCriteria(@PathVariable("searchCriteria") String searchCriteria, @PathVariable("criteriaId") Long criteriaId){

        GenericResponse<List<EmployeeResponse>> response = service.getAllEmployeesByCriteria(searchCriteria, criteriaId);

        if(response.getError() != null){
            return new ResponseEntity<>(response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new GetAllEmployees(response.getData()),
                null,
                HttpStatus.OK);
        //return new GetAllEmployeesResponse(service.getAllEmployeesByCriteria(searchCriteria, id));
    }
/*
    ///// POST /////
    @PostMapping("/addEmployees")
    public EmployeeResponse addEmployee(@RequestBody NewEmployee newEmployee){
        return service.addEmployee(newEmployee);
    }

    ///// PUT /////
    @PutMapping("/updateEmployees/{id}")
    public EmployeeDetailsResponse updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id){
        return service.updateEmployee(employee, id);
    }

    ///// DELETE /////
    @DeleteMapping("/deleteEmployees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return service.deleteEmployee(id);
    }

 */
}

