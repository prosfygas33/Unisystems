package com.example.Unisystems.Employee;

import com.example.Unisystems.Unit.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;

public class EmployeeRequest {

    private int recordNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String telephoneNumber;
    private String startDate;
    private String endDate;
    //ACTIVE,INACTIVE
    private String status;
    //True if type = Unisystems, false if type = external
    private String contactType;
    private String position;
    private String unitName;

    public EmployeeRequest(int recordNumber, String firstName, String lastName, String address, String telephoneNumber, String startDate, String endDate, String status, String contactType, String position, String unitName) {
        this.recordNumber = recordNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.contactType = contactType;
        this.position = position;
        this.unitName = unitName;
    }

    public EmployeeRequest(){ }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}

