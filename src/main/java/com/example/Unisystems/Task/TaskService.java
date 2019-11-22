package com.example.Unisystems.Task;


import com.example.Unisystems.Employee.EmployeeResponse;
import com.example.Unisystems.Error;
import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper mapper;

    public GenericResponse<List<TaskResponse>>getAllTasksById(Long id){
        Iterable<Task> retrieveTasks = taskRepository.findAll();
        List<TaskResponse> tasks = new ArrayList<>();
        for (Task task: retrieveTasks){
            if(id == task.getId())
               tasks.add(mapper.mapTaskResponseFromTask(task)) ;
        }
        if(tasks.isEmpty()) return new GenericResponse<>(new Error(0,"Not Found", "No Task record exist for given id " + id));
        return new GenericResponse<>(tasks);


    }



}
