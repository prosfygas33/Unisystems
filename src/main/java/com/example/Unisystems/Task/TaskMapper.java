package com.example.Unisystems.Task;


import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskResponse mapTasResponseFromTask(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDesc(),
                task.getStatus(),
                task.getUpdateList(),
                task.getOwner()



        );
    }



}
