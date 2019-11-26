package com.example.Unisystems;



import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Employee.*;
import com.example.Unisystems.Unit.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class UnitServiceShould {

    private UnitService service;
    private UnitResponse unitResponseFromMapper;
    private Iterable<Unit> mockUnits;


    @Mock
    private UnitRepository repository;
    @Mock
    private UnitMapper mapper;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        Company c1 = new Company("UniSystems");
        BusinessUnit b1 = new BusinessUnit("BusinessUnitA", c1);
        Department d1 = new Department("Vertical", b1);
//        Unit u1 = new Unit("Fire Squad", d1);

        mockUnits = new ArrayList<Unit>(){
            {
                add(new Unit("Banking",d1));
                add(new Unit("Public",d1));
                add(new Unit("Telecom",d1));
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
        Mockito.verify(mapper, times(3)).mapUnitResponseFromUnit(any());
    }

}

