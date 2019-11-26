package com.example.Unisystems;

import com.example.Unisystems.Company.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class CompanyServiceShould {

    private CompanyService service;
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private CompanyMapper companyMapper;

    private Iterable<Company> mockIterableCompanies;
    private CompanyResponse companyResponseFromMapper;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        companyResponseFromMapper = new CompanyResponse(1, "company1");

        mockIterableCompanies = new ArrayList<Company>(){
            {
                add(new Company("company1"));
                add(new Company("company2"));
            }
        };

        when(companyRepository.findAll()).thenReturn(mockIterableCompanies);
        when(companyMapper.mapCompanyResponseFromCompany(any())).thenReturn(companyResponseFromMapper);

        service = new CompanyService(companyMapper, companyRepository);
    }

    @Test
    public void retrieveCompaniesFromRepository(){
        service.getCompanies();
        Mockito.verify(companyRepository).findAll();
    }

    @Test
    public void usesCompanyMapper(){
        service.getCompanies();
        Mockito.verify(companyMapper, times(2)).mapCompanyResponseFromCompany(any());
    }

    @Test
    public void returnListOfCompanyResponse(){
        List<CompanyResponse> output = service.getCompanies();
        Assert.assertEquals(2, output.size());

        List<CompanyResponse> expected = new ArrayList<>();
        expected.add(companyResponseFromMapper);
        expected.add(companyResponseFromMapper);
        Assert.assertThat(output, is(expected));
    }
}
