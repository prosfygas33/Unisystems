package com.example.Unisystems.Employee;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Unit.Unit;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  int recordNumber;
    private String firstname;
    private String lastname;
    private String address;
    private String telephoneNumber;
    private Date startDate;
    private Date endDate;
    private boolean status;
    //True if type = Unisystems, false if type = external
    private boolean contactType;

    @ManyToOne
    private Company company;

    @ManyToOne
    private BusinessUnit businessUnit;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Unit unit;

    @ManyToOne
    private Set<Task> tasksOwned;

    private String position;

    public Employee(int recordNumber, String firstname, String lastname, String address, String telephoneNumber, Date startDate, Date endDate, boolean status, boolean contactType, Company company, BusinessUnit businessUnit, Department department, Unit unit, Set<Task> tasksOwned, String position) {
        this.recordNumber = recordNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.contactType = contactType;
        this.company = company;
        this.businessUnit = businessUnit;
        this.department = department;
        this.unit = unit;
        this.tasksOwned = tasksOwned;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Set<Task> getTasksOwned() {
        return tasksOwned;
    }

    public void setTasksOwned(Set<Task> tasksOwned) {
        this.tasksOwned = tasksOwned;
    }
}
