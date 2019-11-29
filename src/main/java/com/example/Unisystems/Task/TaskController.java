package com.example.Unisystems.Task;

import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.net.www.content.text.Generic;

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


    @GetMapping("/getTaskByCriteria")
    public ResponseEntity getTaskByDifficulty(@RequestParam(value="difficulty",required = false) String difficulty,@RequestParam(value="numberOfEmployees",required = false) Long numberOfEmployees) {
        GenericResponse<List<TaskResponse>> response;
        if ( difficulty == null && numberOfEmployees == null){
            response = new GenericResponse(new com.example.Unisystems.Error(404,"Not Found","No parameters were given!"));
        }else{
            response = taskService.getTaskByCriteria(difficulty,numberOfEmployees);
        }


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


