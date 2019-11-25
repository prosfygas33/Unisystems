package com.example.Unisystems.RoleAuthentication;

import com.example.Unisystems.Employee.Employee;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private RoleAssignment name;

    //@ManyToMany(mappedBy = "roles")
    //private List<Employee> employees;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private List<Privilege> privileges;

    public Role(RoleAssignment name, List<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleAssignment getName() {
        return name;
    }

    public void setName(RoleAssignment name) {
        this.name = name;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}