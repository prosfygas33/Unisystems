package com.example.Unisystems.Task;


import com.example.Unisystems.Employee.EmployeeResponse;
import com.example.Unisystems.Error;
import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.content.text.Generic;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper mapper;

    public GenericResponse<TaskResponse>getTaskById(Long id){
        Iterable<Task> retrievedTasks = taskRepository.findAll();
        TaskResponse taskResponse = null;

        for (Task task: retrievedTasks){
            if(id == task.getId())
                taskResponse = mapper.mapTaskResponseFromTask(task);
        }
        if(taskResponse == null) return new GenericResponse<>(new Error(0,"Not Found", "No Task record exist for given id " + id));
        return new GenericResponse<>(taskResponse);
    }

    public GenericResponse<String> createTask(TaskRequest taskRequest){
        Task newTask = mapper.mapTaskFromTaskRequest(taskRequest);
        try{
            taskRepository.save(newTask);
            return new GenericResponse<>("Post Successful");
        }catch (Exception e){
            return new GenericResponse<>("Post UnSuccessful");
        }

    }



}
