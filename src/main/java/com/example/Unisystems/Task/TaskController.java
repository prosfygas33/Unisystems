package com.example.Unisystems.Task;

import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class TaskController {


    private TaskService taskService;
    private TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity getTaskById(@PathVariable Long taskId){
        GenericResponse<TaskResponse> response = taskService.getTaskById(taskId);

        if(response.getError() != null){
            return new ResponseEntity<>(
                    response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                response.getData(),
                null,
                HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity createTask(@RequestBody TaskRequest taskRequest) {
        GenericResponse<String> response = taskService.createTask(taskRequest);

        if(response.getError() != null){
            return new ResponseEntity<>(
                    response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                response.getData(),
                null,
                HttpStatus.OK);
    }

    /*@PutMapping("/task/{id}")
    public Task replaceTask(@RequestBody Task updatedTask, @PathVariable Long id) {

        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setDesc(updatedTask.getDesc());
                    task.setEstimationA(updatedTask.getEstimationA());
                    task.setEstimationB(updatedTask.getEstimationA());
                    task.setEstimationC(updatedTask.getEstimationC());
                    task.setStatus(updatedTask.getStatus());
                    task.setAssignedEmployees(updatedTask.getAssignedEmployees());
                    task.setUpdateList(updatedTask.getUpdateList());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    updatedTask.setId(id);
                    return taskRepository.save(updatedTask);
                });
    }
    */
    @DeleteMapping("/task/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

}


