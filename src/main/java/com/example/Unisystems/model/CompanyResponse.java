package com.example.Unisystems.model;

public class CompanyResponse {

    private long id;
    private String name;
    private String field;

    public CompanyResponse(long id, String name, String field) {
        this.id = id;
        this.name = name;
        this.field = field;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
