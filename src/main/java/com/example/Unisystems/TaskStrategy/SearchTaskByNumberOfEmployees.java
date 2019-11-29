package com.example.Unisystems.TaskStrategy;

import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Task.TaskMapper;
import com.example.Unisystems.Task.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SearchTaskByNumberOfEmployees implements SearchTaskStrategy {

    @Override
    public List<Task> execute(String difficulty, Long numberOfEmployees, Iterable<Task> allTasks) {
        List<Task> tasks = new ArrayList<>();

        for( Task task : allTasks ) {
            if ( task.getAssignedEmployees().size() == numberOfEmployees ){
                tasks.add(task);
            }
        }

        return tasks;
    }
}
