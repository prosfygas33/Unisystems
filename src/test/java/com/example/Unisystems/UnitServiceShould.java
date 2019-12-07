package com.example.Unisystems;



import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.BusinessUnit.BusinessUnitResponse;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Employee.*;
import com.example.Unisystems.Unit.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class UnitServiceShould {

    private UnitService service;
    private UnitResponse unitResponseFromMapper;
    private Iterable<Unit> mockUnits;
    private Company c1;
    private Department d1;

    @Mock
    private UnitRepository repository;
    @Mock
    private UnitMapper mapper;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        c1 = new Company("UniSystems");
        BusinessUnit b1 = new BusinessUnit("BusinessUnitA", c1);
        d1 = new Department("Vertical", b1);
//        Unit u1 = new Unit("Fire Squad", d1);

        mockUnits = new ArrayList<Unit>(){
            {
                add(new Unit("Banking",d1));
                add(new Unit("Public",d1));
//                add(new Unit("Telecom",d1));
            }
        };


        unitResponseFromMapper = new UnitResponse(1,"Banking",d1);
        when(repository.findAll()).thenReturn(mockUnits);
        when(mapper.mapUnitResponseFromUnit(any())).thenReturn(unitResponseFromMapper);
        service = new UnitService(repository,mapper);
    }

    @Test
    public void retrieveUnitsFromRepository(){
        service.getUnits();
        Mockito.verify(repository).findAll();
    }

    @Test
    public void usesUnitMapper(){
        service.getUnits();
        Mockito.verify(mapper, times(2)).mapUnitResponseFromUnit(any());
    }

    @Test
    public void returnListOfUnitResponse(){
        List<UnitResponse> output = service.getUnits();
        Assert.assertEquals(2, output.size());

        List<UnitResponse> expected = new ArrayList<>();
        expected.add(new UnitResponse(1, "Banking", d1));
        expected.add(new UnitResponse(1, "Banking", d1));
        Assert.assertThat(output.get(0), Matchers.samePropertyValuesAs(expected.get(0)));
        Assert.assertThat(output.get(1), Matchers.samePropertyValuesAs(expected.get(1)));
    }

}

