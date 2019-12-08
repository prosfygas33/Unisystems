package com.example.Unisystems;

import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.RoleAuthentication.Privilege;
import com.example.Unisystems.RoleAuthentication.Role;
import com.example.Unisystems.RoleAuthentication.RoleAssignment;
import com.example.Unisystems.Task.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskMapperShould {

    private TaskMapper mapper;
    private Task taskInput;
    private Employee employee;
    private TaskResponse expectedOutput;
    private Role role;
    private Privilege readPrivilege;
    private Privilege writePrivilege;
    private List<Privilege> privilege;

    @Before
    public void setUp(){
        privilege = new ArrayList<>();
        mapper = new TaskMapper();
        readPrivilege = new Privilege("readPrivilege");
        writePrivilege = new Privilege("writePrivilege");
        privilege.add(readPrivilege);
        privilege.add(writePrivilege);
        role = new Role(RoleAssignment.ADMIN,privilege);
        role.setId((long) 1);
        employee = new Employee(1,"Panagiotis", "Milios", "Kimolou 14", "2108817081", new Date(113, 12, 1), new Date(), true, true, null, null, null, null,null, "Junior Developer",role);
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
