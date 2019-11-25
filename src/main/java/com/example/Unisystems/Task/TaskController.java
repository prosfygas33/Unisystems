package com.example.Unisystems.Task;

import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

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

    @PutMapping("/task/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable(value = "taskId") Long taskId, @Valid @RequestBody Task taskDetails)
            throws ResourceNotFoundException {

        Task task=taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + taskId));

        task.setTitle(taskDetails.getTitle());
        task.setTitle(taskDetails.getTitle());
        task.setDesc(taskDetails.getDesc());
        task.setEstimationB(taskDetails.getEstimationA());
        task.setEstimationC(taskDetails.getEstimationC());
        task.setStatus(taskDetails.getStatus());
        task.setAssignedEmployees(taskDetails.getAssignedEmployees());
        task.setUpdateList(taskDetails.getUpdateList());
        final Task updateTask =taskRepository.save(task);
        return  ResponseEntity.ok(updateTask);

    }


   /* @PutMapping("/task/{id}")
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
    }*/


    @DeleteMapping("/task/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }


    /*@GetMapping("/taskStatus/{difficulty}")
    public ResponseEntity getStatusDifficulty(@PathVariable Difficulty difficulty) {
        GenericResponse<String> response = taskService.getStatusDifficulty(difficulty);

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
    }*/
}


