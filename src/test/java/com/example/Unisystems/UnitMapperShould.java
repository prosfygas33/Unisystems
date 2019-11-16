package com.example.Unisystems;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Unit.Unit;
import com.example.Unisystems.Unit.UnitResponse;
import com.example.Unisystems.Unit.UnitMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitMapperShould {

    private UnitMapper mapper;
    private Unit unitInput;
    private BusinessUnit businessUnitInput;
    private Company companyInput;
    private Department departmentInput;
    private UnitResponse expectedOutput;

    @Before
    public  void setup(){

        mapper = new UnitMapper();
        //companyInput = new Company("Unisy");
        //businessUnitInput = new BusinessUnit("BsU", companyInput);
        //departmentInput = new Department("Depar",businessUnitInput);
        unitInput = new Unit("Un",departmentInput);
        unitInput.setId(5);
        expectedOutput = mapper.mapUnitResponseFromUnit(unitInput);
    }

        @Test
        public void keepSameId() { Assert.assertEquals(5, expectedOutput.getId()); }

        @Test
        public void keepName() { Assert.assertEquals("Un", expectedOutput.getName()); }

        @Test
       public void keepDepartment(){Assert.assertEquals(departmentInput,expectedOutput.getDepartment()); }
}
