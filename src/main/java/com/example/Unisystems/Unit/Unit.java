package com.example.Unisystems.Unit;

import com.example.Unisystems.Department.Department;

import javax.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private Department department;

    public Unit(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Unit(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
