package com.example.Unisystems.TaskStrategy;

import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Task.TaskMapper;
import com.example.Unisystems.Task.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SearchTaskByMediumDifficultyStrategy implements SearchTaskStrategy {

    @Override
    public List<Task> execute(String difficulty, Long numberOfEmployees, Iterable<Task> allTasks) {
        List<Task> tasks = new ArrayList<>();
        String tempDifficulty = "";

        for( Task task : allTasks ) {
            //O mapper trwei null pointer exception
            tempDifficulty = task.getDifficultyFromEstimation();
            if ( tempDifficulty.equalsIgnoreCase(difficulty) ){
                tasks.add(task);
            }
        }

        return tasks;
    }
}
