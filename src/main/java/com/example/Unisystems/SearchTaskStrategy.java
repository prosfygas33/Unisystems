package com.example.Unisystems;

import com.example.Unisystems.Task.Task;

import java.util.List;

public interface SearchTaskStrategy {

        List<Task> execute(String criteria, Iterable<Task> allTasks);


}
