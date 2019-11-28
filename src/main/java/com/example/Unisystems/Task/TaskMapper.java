package com.example.Unisystems.Task;

import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Employee.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public class TaskMapper {

    @Autowired
    TaskRepository taskRepository;

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
}
