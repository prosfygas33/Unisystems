package com.example.Unisystems;

import com.example.Unisystems.Company.CompanyMapper;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Company.CompanyResponse;
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
        companyInput =new Company("Unis");
        companyInput.setId((long) 5);
        expectedOutput = new CompanyResponse(5,"Unis");
    }

    @Test
    public void mapCompanyResponseFromCompany(){
        CompanyResponse output = mapper.mapCompanyResponseFromCompany(companyInput);
        Assert.assertThat(expectedOutput, Matchers.samePropertyValuesAs(output));
    }
}
