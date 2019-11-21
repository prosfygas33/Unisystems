package com.example.Unisystems.Task;

import com.example.Unisystems.Employee.Employee;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class TaskResponse {

    private long id;
    private String title;
    private String desc;
    private Difficulty   difficultyEstimation;
    private  TaskStatus   status;
    private List<String> UpdateList;
    private List<Employee> assignedEmployees;
    //private Employee owner;


    public TaskResponse(long id, String title, String desc, Difficulty difficultyEstimation, TaskStatus status, List<String> updateList, List<Employee> assignedEmployees) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.difficultyEstimation = difficultyEstimation;
        this.status = status;
        UpdateList = updateList;
        this.assignedEmployees = assignedEmployees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Difficulty getDifficultyEstimation() {
        return difficultyEstimation;
    }

    public void setDifficultyEstimation(Difficulty difficultyEstimation) {
        this.difficultyEstimation = difficultyEstimation;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public List<String> getUpdateList() {
        return UpdateList;
    }

    public void setUpdateList(List<String> updateList) {
        UpdateList = updateList;
    }

    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(List<Employee> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }
}



