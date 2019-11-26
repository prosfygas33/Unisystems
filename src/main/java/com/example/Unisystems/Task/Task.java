package com.example.Unisystems.Task;

import com.example.Unisystems.Employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Task")
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    private String title;
    private String desc;
    private int estimationA;
    private int estimationB;
    private int estimationC;
    private TaskStatus status;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            },
            mappedBy = "tasks")
    @JsonIgnore
    private List<Employee> assignedEmployees = new ArrayList<>();

    @ElementCollection
    private List<String> updateList = new ArrayList<>();

    public Task(String title, String desc, int estimationA, int estimationB, int estimationC, TaskStatus status, List<Employee> assignedEmployees,List<String> updateList) {
        this.title = title;
        this.desc = desc;
        this.estimationA = estimationA;
        this.estimationB = estimationB;
        this.estimationC = estimationC;
        this.status = status;
        this.assignedEmployees = assignedEmployees;
        this.updateList = updateList;
    }

    public Task(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(List<Employee> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }

    public List<String> getUpdateList() {
        return updateList;
    }

    public void setUpdateList(List<String> updateList) {
        this.updateList = updateList;
    }
}
