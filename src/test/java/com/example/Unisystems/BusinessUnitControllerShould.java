package com.example.Unisystems;

import com.example.Unisystems.BusinessUnit.BusinessUnitController;
import com.example.Unisystems.BusinessUnit.BusinessUnitResponse;
import com.example.Unisystems.BusinessUnit.BusinessUnitService;
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

public class BusinessUnitControllerShould {
    private BusinessUnitController controller;

    @Mock
    private BusinessUnitService service;
    @Mock
    private BusinessUnitResponse businessUnit1;
    @Mock
    private BusinessUnitResponse businessUnit2;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        List<BusinessUnitResponse> mockBusinessUnits = new ArrayList<>();
        mockBusinessUnits.add(businessUnit1);
        mockBusinessUnits.add(businessUnit2);
        when(service.getBusinessUnits()).thenReturn(mockBusinessUnits);

        controller = new BusinessUnitController(service);
    }

    @Test
    public void returnAllBusinessUnits(){
        ResponseEntity<List<BusinessUnitResponse>> actual = controller.getBusinessUnits();

        Assert.assertThat(actual.getBody(), CoreMatchers.hasItems(businessUnit1, businessUnit2));
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}
