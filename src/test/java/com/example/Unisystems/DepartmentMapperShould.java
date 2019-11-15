package com.example.Unisystems;

import com.example.Unisystems.mappers.DepartmentMapper;
import com.example.Unisystems.mappers.UnitMapper;
import com.example.Unisystems.model.*;
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
        expectedOutput = new DepartmentResponse(5,"Depar",businessUnitInput);
    }

        @Test
        public void keepSameId() { Assert.assertEquals(5, expectedOutput.getId()); }

        @Test
        public void keepName() { Assert.assertEquals("Depar", expectedOutput.getName()); }

        @Test
       public void keepBusinessUnit(){Assert.assertEquals(businessUnitInput,expectedOutput.getBusinessUnit()); }
}
