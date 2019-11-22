package com.example.Unisystems.Task;

import org.springframework.stereotype.Component;

@Component
public class TaskMapper {


    public TaskResponse mapTaskResponseFromTask(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDesc(),
                mapDifficultyFromEstimation(task).toString(),
                task.getStatus().toString(),
                task.getUpdateList(),
                task.getAssignedEmployees()
        );
    }

    private Difficulty mapDifficultyFromEstimation(Task task) {
        int sumEstimation = task.getEstimationA()+task.getEstimationB()+task.getEstimationC();
        if (sumEstimation < 2){
            return Difficulty.EASY ;
        }
        else if (sumEstimation>=2 && sumEstimation <= 4){

            return Difficulty.MEDIUM;
        }
        else {

            return Difficulty.HARD;
        }
    }
}
