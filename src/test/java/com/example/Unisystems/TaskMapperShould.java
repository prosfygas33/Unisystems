package com.example.Unisystems;

import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Task.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskMapperShould {

    private TaskMapper mapper;
    private Task taskInput;
    private Employee employee;
    private TaskResponse expectedOutput;

    @Before
    public void setUp() throws ParseException {
        mapper = new TaskMapper();
        employee = new Employee("Panagiotis", "Milios", "Kimolou 14", "2108817081", new SimpleDateFormat("dd/mm/yyyy").parse("14/10/2010"), new Date(), true, true, null,null,"Junior Developer");
        employee.setId(10);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        List<String> updateList = new ArrayList<>();
        updateList.add("Initial Commit");
        taskInput = new Task("title","desc",5,4,3, TaskStatus.STARTED,employees,updateList);
        taskInput.setId((long) 5);
        expectedOutput = mapper.mapTaskResponseFromTask(taskInput);
    }

    @Test
    public void keepSameTitle(){
        Assert.assertEquals(taskInput.getTitle(),expectedOutput.getTitle());
    }

    @Test
    public void keepSameDesc(){
        Assert.assertEquals(taskInput.getDesc(),expectedOutput.getDesc());
    }

    @Test
    public void keepSameEstimation(){
        int sumEstimation = taskInput.getEstimationA() + taskInput.getEstimationB() + taskInput.getEstimationC();
        Difficulty difficulty;
        if (sumEstimation < 2){
            difficulty = Difficulty.EASY;
        }
        else if (sumEstimation>=2 && sumEstimation <= 4){

            difficulty = Difficulty.MEDIUM;
        }
        else {
            difficulty = Difficulty.HARD;
        }
        Assert.assertEquals(String.valueOf(difficulty),expectedOutput.getDifficultyEstimation());
    }

    @Test
    public void keepSameStatus(){
        Assert.assertEquals(String.valueOf(taskInput.getStatus()),expectedOutput.getStatus());
    }

    @Test
    public void keepSameUpdateList(){
        Assert.assertEquals(taskInput.getUpdateList(), expectedOutput.getUpdateList());
    }

    @Test
    public void keepSameAssignedEmployees(){
        Assert.assertEquals(taskInput.getAssignedEmployees(),expectedOutput.getAssignedEmployees());
    }

}
