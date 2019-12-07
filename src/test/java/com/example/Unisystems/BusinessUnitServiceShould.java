package com.example.Unisystems;

import com.example.Unisystems.BusinessUnit.*;
import com.example.Unisystems.Company.Company;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class BusinessUnitServiceShould {
    private BusinessUnitService service;
    @Mock
    private BusinessUnitRepository businessUnitRepository;
    @Mock
    private BusinessUnitMapper businessUnitMapper;

    private Iterable<BusinessUnit> mockIterableBusinessUnits;
    private BusinessUnitResponse businessUnitResponseFromMapper;

    private Company company1;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        company1 = new Company("Company1");
        businessUnitResponseFromMapper = new BusinessUnitResponse(1, "BusinessUnit1", company1);

        mockIterableBusinessUnits = new ArrayList<BusinessUnit>(){
            {
                add(new BusinessUnit("BusinessUnit1", new Company("Company1")));
                add(new BusinessUnit("BusinessUnit2", new Company("Company1")));
            }
        };

        when(businessUnitRepository.findAll()).thenReturn(mockIterableBusinessUnits);
        when(businessUnitMapper.mapBusinessUnitResponseFromBusinessUnit(any())).thenReturn(businessUnitResponseFromMapper);

        service = new BusinessUnitService(businessUnitMapper, businessUnitRepository);
    }

    @Test
    public void retrieveBusinessUnitsFromRepository(){
        service.getBusinessUnits();
        Mockito.verify(businessUnitRepository).findAll();
    }

    @Test
    public void usesBusinessUnitMapper(){
        service.getBusinessUnits();
        Mockito.verify(businessUnitMapper, times(2)).mapBusinessUnitResponseFromBusinessUnit(any());
    }

    @Test
    public void returnListOfBusinessUnitResponse(){
        List<BusinessUnitResponse> output = service.getBusinessUnits();
        Assert.assertEquals(2, output.size());

        List<BusinessUnitResponse> expected = new ArrayList<>();
        expected.add(new BusinessUnitResponse(1, "BusinessUnit1", company1));
        expected.add(new BusinessUnitResponse(1, "BusinessUnit1", company1));
        Assert.assertThat(output.get(0), Matchers.samePropertyValuesAs(expected.get(0)));
        Assert.assertThat(output.get(1), Matchers.samePropertyValuesAs(expected.get(1)));
    }
}
