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
                    employee.getFirstName() + " " + employee.getLastName(),
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
                    employee.getFirstName() + " " + employee.getLastName(),
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

    //This method works for @Post Task aswell
    public Employee mapEmployeeFromEmployeeRequest(EmployeeRequest employeeRequest,List<Task> taskList) throws ParseException {
        Iterable<Employee> retrievedEmployees = employeeRepository.findAll();

        //Employee exists, assign him to the task
        for ( Employee employee : retrievedEmployees ){
            if ( employeeRequest.getRecordNumber() == employee.getRecordNumber()){
                for ( Task task : taskList) {
                    employee.addTask(task);
                }
                employeeRepository.save(employee);
                return null;
            }
        }

        boolean status = false;
        boolean contactStatus = false;
        if ( employeeRequest.getStatus().equalsIgnoreCase("ACTIVE")) {
            status = true;
        }
        if ( employeeRequest.getContactType().equalsIgnoreCase("Unisystems") ){
            contactStatus = true;
        }

        return new Employee(
                employeeRequest.getRecordNumber(),
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

        int i = 0;
        if ( taskRequest.getEmployees() != null ) {
            for (EmployeeRequest employeeRequest : taskRequest.getEmployees()) {
                int j = 0;
                while (j < taskRequest.getEmployees().size()) {
                    if (i != j) {
                        if (employeeRequest.getUnitName().equalsIgnoreCase(taskRequest.getEmployees().get(j).getUnitName())) {
                            return null;
                        }
                    }
                    j++;
                }
                i++;
                Employee e = mapEmployeeFromEmployeeRequest(employeeRequest, taskList);
                if (e != null) {
                    employeeRepository.save(e);
                    employees.add(e);
                }
            }
            return employees;
        }else{
            return null;
        }

    }
}
