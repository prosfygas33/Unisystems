package com.example.Unisystems.Employee;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.RoleAuthentication.Role;
import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Unit.Unit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "employees_tasks",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "task_id") })
    private List<Task> tasks = new ArrayList();

    private String position;

    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
  // @JoinTable(name = "User_ROLES",
    //        joinColumns =  @JoinColumn(name = "employee_id"),inverseJoinColumns= @JoinColumn(name = "role_id"))
    private Role role;

   /* @ManyToOne
   @JoinTable(name = "employees_roles",
    joinColumns = {@JoinColumn(name="employee_id")},
            inverseJoinColumns ={ @JoinColumn(name = "role_id") })

          // name = "employees_roles",
            //joinColumns = @JoinColumn(
                             //   name = "employee_id", referencedColumnName = "id"),
           // inverseJoinColumns = @JoinColumn(
                   // name = "role_id", referencedColumnName = "id"))
    private Role role;*/

    public Employee() {
    }

    public Employee(int recordNumber, String firstname, String lastname, String address, String telephoneNumber, Date startDate, Date endDate, boolean status, boolean contactType, Company company, BusinessUnit businessUnit, Department department, Unit unit, List<Task> tasks, String position, String username, String password, String email, Role role) {
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
        this.tasks = tasks;
        this.position = position;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
