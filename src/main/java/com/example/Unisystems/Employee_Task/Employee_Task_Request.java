package com.example.Unisystems.Employee_Task;

import com.example.Unisystems.Employee.Employee;
import com.example.Unisystems.Task.Task;

import java.util.List;

public class Employee_Task_Request {

    private List<Employee> employees;
    private Task task;

    public Employee_Task_Request(List<Employee> employees, Task task) {
        this.employees = employees;
        this.task = task;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employee) {
        this.employees = employee;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
