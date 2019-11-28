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

    //DEPRECATED
    //private  int recordNumber;
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
    private List<Task> tasks = new ArrayList();


    private String position;

    public Employee(String firstname, String lastname, String address, String telephoneNumber, Date startDate, Date endDate, boolean status, boolean contactType, Unit unit, List<Task> tasks, String position) {
        this.firstName = firstname;
        this.lastName = lastname;
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

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
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
}
