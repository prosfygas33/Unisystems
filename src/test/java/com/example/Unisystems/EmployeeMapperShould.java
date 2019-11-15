package com.example.Unisystems;


import com.example.Unisystems.mappers.EmployeeMapper;
import com.example.Unisystems.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class EmployeeMapperShould {


    private EmployeeMapper employeeMapper;

    private Employee employeeInput;
    private EmployeeResponse employeeResponseOutput;
    private Unit unit;
    private Department department;
    private BusinessUnit businessUnit;
    private Company company;

    @Before
    public void setUp(){
        employeeMapper = new EmployeeMapper();

        company = new Company("Unisystems");
        company.setId((long) 1);
        businessUnit = new BusinessUnit("BusinessUnitName",company);
        businessUnit.setId((long) 1);
        department = new Department("DepartmentName",businessUnit);
        department.setId((long) 1);
        unit = new Unit("UnitName",department);
        unit.setId(1);
        employeeInput = new Employee("Panagiotis", "Milios", "Kimolou 14", "2108817081", new Date(113, 12, 1), new Date(), true, true, company, businessUnit, department, unit, "Junior Developer");
        employeeInput.setId(10);

        employeeResponseOutput = employeeMapper.mapEmployeeResponseFromEmployee(employeeInput);
    }

    @Test
    public void keepSameUnitId(){
        Assert.assertEquals(1,employeeResponseOutput.getId());
    }

    @Test
    public void keepSameEmployeeId(){
        Assert.assertEquals(10,employeeResponseOutput.getRecordNumber());
    }

    @Test
    public void keepSameFullName(){
        Assert.assertEquals("Panagiotis Milios",employeeResponseOutput.getFullName());
    }

    @Test
    public void keepSameTelephoneNumber(){
        Assert.assertEquals("2108817081", employeeResponseOutput.getTelephone());
    }

    @Test
    public void keepSameWorkingPeriod(){
        Assert.assertEquals(employeeInput.getStartDate()+ " - " + employeeInput.getEndDate(),employeeResponseOutput.getWorkingPeriod());
    }

    @Test
    public void keepSameStatus(){
        boolean response;
        if ( employeeResponseOutput.getStatus() == Status.ACTIVE ){
            response = true;
        }else{
            response = false;
        }
        Assert.assertEquals(true, response);
    }

    @Test
    public void keepSameContactType(){
        boolean response;
        if ( employeeResponseOutput.getContactType().equalsIgnoreCase("Active") ){
            response = true;
        }else{
            response = false;
        }
        Assert.assertEquals(true, response);
    }

    @Test
    public void keepSamePosition(){
        Assert.assertEquals("Junior Developer",employeeResponseOutput.getPosition());
    }

    @Test
    public void keepSameUnitName(){
        Assert.assertEquals("UnitName",employeeResponseOutput.getUnit());
    }


}
