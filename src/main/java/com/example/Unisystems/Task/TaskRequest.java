package com.example.Unisystems.Task;

import com.example.Unisystems.Employee.Employee;

import java.util.List;

public class TaskRequest {

    private String title;
    private String desc;
    private int estimationA;
    private int estimationB;
    private int estimationC;
    private String status;

    public TaskRequest(String title, String desc, int estimationA, int estimationB, int estimationC, String status) {
        this.title = title;
        this.desc = desc;
        this.estimationA = estimationA;
        this.estimationB = estimationB;
        this.estimationC = estimationC;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
