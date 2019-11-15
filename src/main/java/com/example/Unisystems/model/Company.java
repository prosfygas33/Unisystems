package com.example.Unisystems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Company(String name, String field) {
        this.name = name;

    }

    public Company(String uniSystems) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
