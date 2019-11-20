package com.example.Unisystems.Task;

import java.util.List;

public class GetAllTasks {

    private List<TaskResponse> tasks;

    public GetAllTasks(List<TaskResponse> tasks) {
        this.tasks = tasks;
    }

    public List<TaskResponse> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskResponse> tasks) {
        this.tasks = tasks;
    }
}
