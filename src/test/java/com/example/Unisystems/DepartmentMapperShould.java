package com.example.Unisystems;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Department.DepartmentResponse;
import com.example.Unisystems.Unit.Unit;
import com.example.Unisystems.Department.DepartmentMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepartmentMapperShould {

    private DepartmentMapper mapper;
    private Unit unitInput;
    private BusinessUnit businessUnitInput;
    private Company companyInput;
    private Department departmentInput;
    private DepartmentResponse expectedOutput;


    @Before
    public void setup(){
        mapper = new DepartmentMapper();
        departmentInput = new Department("Depar",businessUnitInput);
        departmentInput.setId((long) 5);
        expectedOutput = mapper.mapDepartmentResponseFromDepartment(departmentInput);
    }

        @Test
        public void keepSameId() { Assert.assertEquals(5, expectedOutput.getId()); }

        @Test
        public void keepName() { Assert.assertEquals("Depar", expectedOutput.getName()); }

        @Test
       public void keepBusinessUnit(){Assert.assertEquals(businessUnitInput,expectedOutput.getBusinessUnit()); }
}
