package com.example.Unisystems.services;

import com.example.Unisystems.SearchEmployeeStrategy;
import com.example.Unisystems.SearchEmployeeStrategyFactory;
import com.example.Unisystems.mappers.EmployeeMapper;
import com.example.Unisystems.model.Employee;
import com.example.Unisystems.model.Error;
import com.example.Unisystems.model.EmployeeResponse;
import com.example.Unisystems.model.GenericResponse;
import com.example.Unisystems.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SearchEmployeeStrategyFactory searchEmployeeStrategyFactory;

    public List<EmployeeResponse> getEmployees(){
        Iterable<Employee> retrievedEmployees = employeeRepository.findAll();
        List<EmployeeResponse> employees = new ArrayList<>();

        for ( Employee employee : retrievedEmployees ){
            employees.add(employeeMapper.mapEmployeeResponseFromEmployee(employee));
        }

        return employees;
    }

    /*public GenericResponse<List<EmployeeResponse>> getEmployeesById(String searchCriteria, long id){
        Iterable<Employee> retrievedEmployees = employeeRepository.findAll();
        List<EmployeeResponse> employees; //= new ArrayList<>();

        SearchEmployeeStrategy strategy = searchEmployeeStrategyFactory.makeStrategyForCriteria(searchCriteria);
        employees = employeeMapper.mapAllEmployees(strategy.execute( id,retrievedEmployees));

        return GenericResponse<>(employeesToReturn);
    }*/

    public GenericResponse<List<EmployeeResponse>> getEmployeesById(String searchCriteria, long id) {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeesToReturn = new ArrayList<>();

        if (searchCriteria.equals("employees")) {

            if (!employeeRepository.findById(id).isPresent())
                return new GenericResponse<>(new Error(0, "Wrong Input", "Employee with id " + id + " does not exist"));

            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    employeesToReturn.add(employeeMapper.mapEmployeeResponseFromEmployee(employee));
                }
            }
        }
        return new GenericResponse<>(employeesToReturn);
    }



}
