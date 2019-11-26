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
    public ResponseEntity getTaskById(@PathVariable Long taskId) {
        GenericResponse<TaskResponse> response = taskService.getTaskById(taskId);

        if (response.getError() != null) {
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

        if (response.getError() != null) {
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
    public ResponseEntity updateTask(@PathVariable(value = "taskId") Long taskId, @Valid @RequestBody TaskRequest taskDetails)
            throws RuntimeException {
        GenericResponse<TaskResponse> response = taskService.updateTaskFromTaskRequest(taskDetails);
        if (response.getError() != null) {
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



    @DeleteMapping("/task/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }


    @GetMapping("/getTaskByCriteria/{criteria}")
    public ResponseEntity getTaskByCriteria(@PathVariable String criteria) {
        GenericResponse<List<TaskResponse>> response= taskService.getTaskByCriteria(criteria);

        if(response.getError() != null){
            return new ResponseEntity<>(response.getError(),
                    null,
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new GetAllTasks(response.getData()),
                null,
                HttpStatus.OK);

    }
}


