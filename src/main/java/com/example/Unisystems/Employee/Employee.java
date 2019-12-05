package com.example.Unisystems.Employee;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.RoleAuthentication.Role;
import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Unit.Unit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "record_number")
    private  int recordNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    private boolean status;
    //True if type = Unisystems, false if type = external
    @Column(name = "contact_type")
    private boolean contactType;



    @ManyToOne
    private Company company;

    @ManyToOne
    private BusinessUnit businessUnit;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Unit unit;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "employees_tasks",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks = new ArrayList();

    private String position;

    @ManyToOne
    @JoinTable(name = "employees_roles",
    joinColumns = {@JoinColumn(name="employee_id")},
            inverseJoinColumns ={ @JoinColumn(name = "role_id") })

          /*  name = "employees_roles",
            joinColumns = @JoinColumn(
                                name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))*/
    private Role role;

    public Employee() {
    }

    public Employee(int recordNumber, String firstname, String lastname, String address, String telephoneNumber, Date startDate, Date endDate, boolean status, boolean contactType, Company company, BusinessUnit businessUnit, Department department, Unit unit, List<Task> tasks, String position, Role role) {
        this.recordNumber = recordNumber;
        this.firstName = firstname;
        this.lastName = lastname;
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
        this.tasks = tasks;
        this.position = position;
        this.role = role;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
