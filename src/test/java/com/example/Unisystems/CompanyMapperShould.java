package com.example.Unisystems;

import com.example.Unisystems.mappers.CompanyMapper;
import com.example.Unisystems.model.Company;
import com.example.Unisystems.model.CompanyResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompanyMapperShould {


    private CompanyMapper mapper;
    private Company companyInput;
    private CompanyResponse expectedOutput;


    @Before
    public void setup(){

        mapper = new CompanyMapper();
        companyInput =new Company("unis");
        companyInput.setId((long) 5);
        expectedOutput = new CompanyResponse(5,"unis");
    }

    @Test
    public void mapCompanyResponseFromCompany(){
        CompanyResponse output = mapper.mapCompanyResponseFromCompany(companyInput);
        Assert.assertThat(expectedOutput, Matchers.samePropertyValuesAs(output));
    }
}
