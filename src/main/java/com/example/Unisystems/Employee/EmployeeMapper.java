package com.example.Unisystems.Employee;

import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Task.TaskMapper;
import com.example.Unisystems.Task.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TaskMapper taskMapper;

    public EmployeeResponse mapEmployeeResponseFromEmployee(Employee employee){
        if ( employee.getUnit() != null ) {
            return new EmployeeResponse(
                    employee.getId(),
                    employee.getFirstname() + " " + employee.getLastname(),
                    employee.getTelephoneNumber(),
                    employee.getStartDate() + " - " + employee.getEndDate(),
                    employee.isStatus() ? Status.ACTIVE : Status.INACTIVE,
                    employee.isContactType() ? "ACTIVE" : "EXTERNAL",
                    employee.getPosition(),
                    employee.getTasks(),
                    employee.getUnit().getName()
            );
        }else{
            return new EmployeeResponse(
                    employee.getId(),
                    employee.getFirstname() + " " + employee.getLastname(),
                    employee.getTelephoneNumber(),
                    employee.getStartDate() + " - " + employee.getEndDate(),
                    employee.isStatus() ? Status.ACTIVE : Status.INACTIVE,
                    employee.isContactType() ? "ACTIVE" : "EXTERNAL",
                    employee.getPosition(),
                    employee.getTasks(),
                    "Not assigned to a Unit yet!"
            );
        }
    }

    public List<EmployeeResponse> mapAllEmployees(List<Employee> employees){
        List<EmployeeResponse> employeesResponse = new ArrayList<>();

        for ( Employee employee : employees ){
            employeesResponse.add(mapEmployeeResponseFromEmployee(employee));
        }
        return employeesResponse;
    }

    public Employee mapEmployeeFromEmployeeRequest(EmployeeRequest employeeRequest,List<Task> taskList) throws ParseException {
        boolean status = false;
        boolean contactStatus = false;
        if ( employeeRequest.getStatus().equalsIgnoreCase("ACTIVE")) {
            status = true;
        }
        if ( employeeRequest.getContactType().equalsIgnoreCase("Unisystems") ){
            contactStatus = true;
        }

        return new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getAddress(),
                employeeRequest.getTelephoneNumber(),
                new SimpleDateFormat("dd/mm/yyyy").parse(employeeRequest.getStartDate()),
                new SimpleDateFormat("dd/mm/yyyy").parse(employeeRequest.getEndDate()),
                status,
                contactStatus,
                null,
                taskList,
                employeeRequest.getPosition()
        );
    }

    public List<Employee> mapAllEmployeesRequest(TaskRequest taskRequest,List<Task> taskList) throws ParseException {
        List<Employee> employees = new ArrayList<>();

        for ( EmployeeRequest employeeRequest : taskRequest.getEmployees() ){
            Employee e = mapEmployeeFromEmployeeRequest(employeeRequest,taskList);
            employeeRepository.save(e);
            employees.add(e);
        }
        return employees;
    }
}
