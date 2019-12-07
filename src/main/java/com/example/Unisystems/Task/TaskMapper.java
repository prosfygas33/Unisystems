package com.example.Unisystems.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    @Autowired
    TaskRepository taskRepository;

    public TaskResponse mapTaskResponseFromTask(Task task){
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
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

    public Task mapTaskFromTaskRequest(TaskRequest taskRequest) {
        return new Task(
                taskRequest.getTitle(),
                taskRequest.getDesc(),
                taskRequest.getEstimationA(),
                taskRequest.getEstimationB(),
                taskRequest.getEstimationC(),
                mapStatus(taskRequest.getStatus()),
                null,
                null
        );
    }

    public Task updateTaskFromTaskRequest(Task task, TaskRequest taskRequest){
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDesc());
        task.setEstimationA(taskRequest.getEstimationA());
        task.setEstimationB(taskRequest.getEstimationB());
        task.setEstimationC(taskRequest.getEstimationC());
        task.setStatus(mapStatus(taskRequest.getStatus()));

        return task;
    }

    private TaskStatus mapStatus(String status){
        if (status.equalsIgnoreCase("NEW")){
            return TaskStatus.NEW;
        }else if ( status.equalsIgnoreCase("STARTED")){
            return TaskStatus.STARTED;
        }else{
            // Θέλει κι άλλο έλεγγο σε περίπτωση άκυρης τιμής.
            return TaskStatus.DONE;
        }
    }

    public List<TaskResponse> mapAllTasks(List<Task> tasks){
        List<TaskResponse> tasksResponse = new ArrayList<>();

        for ( Task task : tasks ){
            tasksResponse.add(mapTaskResponseFromTask(task));
        }
        return tasksResponse;
    }
}




