package com.example.Unisystems.model;

public class EmployeeResponse {

    private long id;
    private long recordNumber;
    private String fullName;
    private String telephone;
    private String workingPeriod;
    private Status status;
    private String contactType;
    private String position;
    private String unitName;

    public EmployeeResponse(long id, long recordNumber, String fullName, String telephone, String workingPeriod, Status status, String contactType, String position, String unitName) {
        this.id = id;
        this.recordNumber = recordNumber;
        this.fullName = fullName;
        this.telephone = telephone;
        this.workingPeriod = workingPeriod;
        this.status = status;
        this.contactType = contactType;
        this.position = position;
        this.unitName = unitName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(long recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWorkingPeriod() {
        return workingPeriod;
    }

    public void setWorkingPeriod(String workingPeriod) {
        this.workingPeriod = workingPeriod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUnit() {
        return unitName;
    }

    public void setUnit(String unitName) {
        this.unitName = unitName;
    }
}
