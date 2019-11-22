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
    private String difficultyEstimation;
    private String status;
    private List<String> updateList;
    private List<Employee> assignedEmployees;
    //private Employee owner;


    public TaskResponse(long id, String title, String desc, String difficultyEstimation, String status, List<String> updateList, List<Employee> assignedEmployees) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.difficultyEstimation = difficultyEstimation;
        this.status = status;
        this.updateList = updateList;
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

    public String getDifficultyEstimation() {
        return difficultyEstimation;
    }

    public void setDifficultyEstimation(String difficultyEstimation) {
        this.difficultyEstimation = difficultyEstimation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getUpdateList() {
        return updateList;
    }

    public void setUpdateList(List<String> updateList) {
        this.updateList = updateList;
    }

    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(List<Employee> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }
}



