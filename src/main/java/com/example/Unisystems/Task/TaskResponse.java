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
    private int estimationA;
    private int estimationB;
    private int estimationC;
    private  TaskStatus   status;
    private List<String> UpdateList;
    private Employee owner;

    public TaskResponse(long id, String title, String desc, int estimationA, int estimationB, int estimationC, TaskStatus status, List<String> updateList, Employee owner) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.estimationA = estimationA;
        this.estimationB = estimationB;
        this.estimationC = estimationC;
        this.status = status;
        UpdateList = updateList;
        this.owner = owner;
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

    public int getEstimationA() {
        return estimationA;
    }

    public void setEstimationA(int estimationA) {
        this.estimationA = estimationA;
    }

    public int getEstimationB() {
        return estimationB;
    }

    public void setEstimationB(int estimationB) {
        this.estimationB = estimationB;
    }

    public int getEstimationC() {
        return estimationC;
    }

    public void setEstimationC(int estimationC) {
        this.estimationC = estimationC;
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

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }
}



