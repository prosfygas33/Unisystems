package com.example.Unisystems;

import com.example.Unisystems.mappers.BusinessUnitMapper;
import com.example.Unisystems.model.BusinessUnit;
import com.example.Unisystems.model.BusinessUnitResponse;
import com.example.Unisystems.model.Company;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusinessUnitMapperShould {

    private BusinessUnitMapper mapper;
    private BusinessUnit businessUnitInput;
    private Company companyInput;
    private BusinessUnitResponse expectedOutput;

    @Before
    public void setup() {

        mapper = new BusinessUnitMapper();
        companyInput = new Company("unis");
        businessUnitInput = new BusinessUnit("BsU", companyInput);
        businessUnitInput.setId((long) 5);
        expectedOutput = new BusinessUnitResponse(5, "BsU", companyInput);

    }

      //  @Test
        //public void mapBusinessUnitResponseFromBusinessUnit () {
          //  BusinessUnitResponse output = mapper.mapBusinessUnitResponseFromBusinessUnit(businessUnitInput);
            //Assert.assertThat(expectedOutput, Matchers.samePropertyValuesAs(output));
        //}

        @Test
        public void keepSameId() {
            Assert.assertEquals(5, expectedOutput.getId());
        }

        @Test
        public void keepName() { Assert.assertEquals("BsU", expectedOutput.getName()); }

        @Test
       public void keepCompany(){Assert.assertEquals(companyInput,expectedOutput.getCompany()); }


    }

