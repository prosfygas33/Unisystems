package com.example.Unisystems;

import com.example.Unisystems.Company.CompanyController;
import com.example.Unisystems.Company.CompanyResponse;
import com.example.Unisystems.Company.CompanyService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class CompanyControllerShould {

    private CompanyController controller;

    @Mock
    private CompanyService service;
    @Mock
    private CompanyResponse company1;
    @Mock
    private CompanyResponse company2;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        List<CompanyResponse> mockCompanies = new ArrayList<>();
        mockCompanies.add(company1);
        mockCompanies.add(company2);
        when(service.getCompanies()).thenReturn(mockCompanies);

        controller = new CompanyController(service);
    }
/*
    @Test
    public void returnAllCompanies(){
        ResponseEntity<List<CompanyResponse>> actual = controller.getAllCompanies();

        Assert.assertThat(actual.getBody(), CoreMatchers.hasItems(company1, company2));
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
*/
}
