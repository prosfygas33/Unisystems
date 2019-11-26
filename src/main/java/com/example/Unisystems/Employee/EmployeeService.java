package com.example.Unisystems.Employee;

import com.example.Unisystems.Error;
import com.example.Unisystems.GenericResponse;
import com.example.Unisystems.SearchEmployeeStrategy;
import com.example.Unisystems.SearchEmployeeStrategyFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;
    private EmployeeMapper mapper;
    private SearchEmployeeStrategyFactory factory;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper, SearchEmployeeStrategyFactory factory) {
        this.repository = repository;
        this.mapper = mapper;
        this.factory = factory;
    }

    public List<EmployeeResponse> getAllEmployees() {
        Iterable<Employee> retrieveEmployees = repository.findAll();
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            employees.add(mapper.mapEmployeeResponseFromEmployee(employee));
        }
        return employees;
    }

    public GenericResponse<List<EmployeeResponse>>getAllEmployeesById(Long id) {
        Iterable<Employee> retrieveEmployees = repository.findAll();
        List<EmployeeResponse> employees = new ArrayList<>();
        for(Employee employee: retrieveEmployees){
            if(id == employee.getId())
                employees.add(mapper.mapEmployeeResponseFromEmployee(employee));

        }
        if(employees.isEmpty())  return new GenericResponse<>(new Error(0,"Not Found", "No employee record exist for given id " + id));
        return new GenericResponse<>(employees);
    }

    public GenericResponse<List<EmployeeResponse>> getAllEmployeesByCriteria(String criteria, Long id) {
        Iterable<Employee> retrieveEmployees = repository.findAll();
        List<EmployeeResponse> employees;// = new ArrayList<>();
        SearchEmployeeStrategy strategy = factory.makeStrategyForCriteria(criteria);
        if(strategy == null)  return new GenericResponse<>(new Error(0,"Wrong Input", "This " +  criteria + " do not exist"));

        employees = mapper.mapAllEmployees(strategy.execute(id, retrieveEmployees));

        if(employees.isEmpty())  return new GenericResponse<>(new Error(0,"Not Found", "No employee record exist for given id " + id));

        return new GenericResponse<>(employees);
    }

    /*
    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "OK";
    }*/
}