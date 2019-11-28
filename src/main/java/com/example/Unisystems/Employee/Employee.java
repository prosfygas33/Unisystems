package com.example.Unisystems.Employee;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Unit.Unit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    private int recordNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String telephoneNumber;
    private Date startDate;
    private Date endDate;
    private boolean status;
    //True if type = Unisystems, false if type = external
    private boolean contactType;

    @ManyToOne
    private Unit unit;

    //Owner of the relation
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "employees_tasks",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks;


    private String position;

    public Employee(int recordNumber, String firstName, String lastName, String address, String telephoneNumber, Date startDate, Date endDate, boolean status, boolean contactType, Unit unit, List<Task> tasks, String position) {
        this.recordNumber = recordNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.contactType = contactType;
        this.unit = unit;
        this.tasks = tasks;
        this.position = position;
    }

    public Employee(){
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isContactType() {
        return contactType;
    }

    public void setContactType(boolean contactType) {
        this.contactType = contactType;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

   /* public List<Task> getTasksOwned() {
        return tasks;
    }

    public void setTasksOwned(List<Task> tasksOwned) {
        this.tasks = tasksOwned;
    }*/

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }
}
