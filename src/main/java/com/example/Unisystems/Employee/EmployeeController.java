package com.example.Unisystems.Employee;

import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    ///// GET /////
    @GetMapping("/employees")
    public ResponseEntity getAllEmployees(){
        return new ResponseEntity<>(
                new GetAllEmployees(service.getAllEmployees()),
                null,
                HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getAllEmployeesByUnitId(@PathVariable Long id){
        GenericResponse<List<EmployeeResponse>> response = service.getAllEmployeesByUnitId(id);

        if(response.getError() != null){
            return new ResponseEntity<>(response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new GetAllEmployees(response.getData()),
                null,
                HttpStatus.OK);
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

