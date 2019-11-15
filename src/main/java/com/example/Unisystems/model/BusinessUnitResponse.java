package com.example.Unisystems.model;

public class BusinessUnitResponse {

    private long id;
    private String name;
    private String type;

    private Company company;

    public BusinessUnitResponse(long id, String name, String type, Company company) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
