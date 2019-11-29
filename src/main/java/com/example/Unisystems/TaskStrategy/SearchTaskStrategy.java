package com.example.Unisystems.TaskStrategy;

import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Task.TaskResponse;

import java.util.List;

public interface SearchTaskStrategy {
        List<Task> execute(String difficulty, Long numberOfEmployees, Iterable<Task> allTasks);
}
