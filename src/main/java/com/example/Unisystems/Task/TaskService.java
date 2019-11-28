package com.example.Unisystems.Task;


import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Employee.EmployeeRepository;
import com.example.Unisystems.Employee.EmployeeRequest;
import com.example.Unisystems.Employee.EmployeeResponse;
import com.example.Unisystems.Employee_Task.Employee_Task_Mapper;
import com.example.Unisystems.Employee_Task.Employee_Task_Request;
import com.example.Unisystems.Error;
import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.content.text.Generic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private Employee_Task_Mapper employee_task_mapper;

    public GenericResponse<TaskResponse>getTaskById(Long id){
        Iterable<Task> retrievedTasks = taskRepository.findAll();
        TaskResponse taskResponse = null;

        for (Task task: retrievedTasks){
            if(id == task.getId())
                taskResponse = taskMapper.mapTaskResponseFromTask(task);
        }
        if(taskResponse == null) return new GenericResponse<>(new Error(0,"Not Found", "No Task record exist for given id " + id));
        return new GenericResponse<>(taskResponse);
    }

    public GenericResponse<String> createTask(TaskRequest taskRequest) throws ParseException {
        GenericResponse<String> genericResponse = employee_task_mapper.mapTaskEmployeeRequest(taskRequest);
        //employee_task_request.getTask().setAssignedEmployees(employee_task_request.getEmployees());

        return genericResponse;
    }



}
