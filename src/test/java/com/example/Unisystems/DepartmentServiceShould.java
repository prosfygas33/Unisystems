package com.example.Unisystems;



import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.*;
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

public class DepartmentServiceShould {

    private DepartmentService service;
    private DepartmentResponse DepartmentResponseFromMapper;
    private Iterable<Department> mockDepartments;


    @Mock
    private DepartmentRepository repository;
    @Mock
    private DepartmentMapper mapper;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        Company c1 = new Company("UniSystems");
        BusinessUnit b1 = new BusinessUnit("BusinessUnitA", c1);
        //Department d1 = new Department("Vertical", b1);
//        Unit u1 = new Unit("Fire Squad", d1);

        mockDepartments = new ArrayList<Department>(){
            {
                add(new Department("Dept1",b1));
                add(new Department("Dept2",b1));
                add(new Department("Dept3",b1));
            }
        };


        DepartmentResponseFromMapper = new DepartmentResponse(1,"Dept4",b1);
        when(repository.findAll()).thenReturn(mockDepartments);
        when(mapper.mapDepartmentResponseFromDepartment(any())).thenReturn(DepartmentResponseFromMapper);
        service = new DepartmentService(repository,mapper);
    }

    @Test
    public void retrieveUnitsFromRepository(){
        service.getDepartments();
        Mockito.verify(repository).findAll();
    }

    @Test
    public void usesUnitMapper(){
        service.getDepartments();
        Mockito.verify(mapper, times(3)).mapDepartmentResponseFromDepartment(any());
    }

}

