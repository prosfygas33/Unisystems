package com.example.Unisystems.Employee_Task;

import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Employee.EmployeeMapper;
import com.example.Unisystems.Employee.EmployeeRepository;
import com.example.Unisystems.Employee.EmployeeRequest;
import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Task.TaskMapper;
import com.example.Unisystems.Task.TaskRepository;
import com.example.Unisystems.Task.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Employee_Task_Mapper {

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee_Task_Request mapTaskEmployeeRequest(TaskRequest taskRequest) throws ParseException {
        Task task = taskMapper.mapTaskFromTaskRequest(taskRequest);
        taskRepository.save(task);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        List<Employee> employees = employeeMapper.mapAllEmployeesRequest(taskRequest,taskList);
        for ( Employee employee : employees ){
            employeeRepository.save(employee);
        }
        return null;
    }

}
