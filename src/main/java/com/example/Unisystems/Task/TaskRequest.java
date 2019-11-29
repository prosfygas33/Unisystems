package com.example.Unisystems.Task;

import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Employee.EmployeeRequest;

import java.util.List;

public class TaskRequest {

    private Long id;
    private String title;
    private String desc;
    private int estimationA;
    private int estimationB;
    private int estimationC;
    private String status;
    private List<EmployeeRequest> assignedEmployees;
    private List<Long> employeesIds;

    public TaskRequest(String title, String desc, int estimationA, int estimationB, int estimationC, String status, List<EmployeeRequest> employees ) {
        this.title = title;
        this.desc = desc;
        this.estimationA = estimationA;
        this.estimationB = estimationB;
        this.estimationC = estimationC;
        this.status = status;
        this.assignedEmployees = employees;
    }

    public TaskRequest(Long id, String title, String desc, int estimationA, int estimationB, int estimationC, String status, List<Long> employeesIds) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.estimationA = estimationA;
        this.estimationB = estimationB;
        this.estimationC = estimationC;
        this.status = status;
        this.employeesIds = employeesIds;
    }

    public TaskRequest() {
    }

    public List<EmployeeRequest> getEmployees() {
        return assignedEmployees;
    }

    public void setEmployees(List<EmployeeRequest> employees) {
        this.assignedEmployees = employees;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Long> getEmployeesIds() {
        return employeesIds;
    }

    public void setEmployeesIds(List<Long> employeesIds) {
        this.employeesIds = employeesIds;
    }
}
