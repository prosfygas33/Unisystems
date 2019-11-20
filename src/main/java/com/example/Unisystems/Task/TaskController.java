package com.example.Unisystems.Task;

import com.example.Unisystems.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/task{taskid}")
    public ResponseEntity getAllTasksById(@PathVariable Long id){
        GenericResponse<List<TaskResponse>> response=taskService.getAllTasksById(id);

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


