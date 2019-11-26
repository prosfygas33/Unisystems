package com.example.Unisystems;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Employee.*;
import com.example.Unisystems.Unit.Unit;
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

public class EmployeeServiceShould {

    private EmployeeService service;
    private EmployeeResponse employeeResponseFromMapper;
    private Iterable<Employee> mockEmployees;
    private SearchEmployeeStrategyFactory factory;

    @Mock
    private EmployeeRepository repository;
    @Mock
    private EmployeeMapper mapper;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        Company c1 = new Company("UniSystems");
        BusinessUnit b1 = new BusinessUnit("BusinessUnitA", c1);
        Department d1 = new Department("Human Resources", b1);
        Unit u1 = new Unit("Fire Squad", d1);

        mockEmployees = new ArrayList<Employee>(){
            {
                add(new Employee(111,"Panagiotis", "Milios", "Kimolou 14", "2108817081", new Date(113, 12, 1), new Date(), true, true, c1, b1, d1, u1, "Junior Developer"));
                add(new Employee(122,"Petros", "Euthimiou", "Spetson 17", "2108834081", new Date(111, 5, 15), new Date(), true, true, c1, b1, d1, u1, "Senior Developer"));
                add(new Employee(123,"Dimitris", "papadopoulos", "Spartis 25", "2108855284", new Date(110, 11, 5), new Date(), true, true, c1, b1, d1, u1, "Hr officer"));
            }
        };
        employeeResponseFromMapper = new EmployeeResponse(1, 132, "Kitsos Nikolaos", "2108834082", "2010-05-10 - 2012-06-05", Status.INACTIVE, "uniSystems", "Junior Developer", "unitA");
        when(repository.findAll()).thenReturn(mockEmployees);
        when(mapper.mapEmployeeResponseFromEmployee(any())).thenReturn(employeeResponseFromMapper);
        service = new EmployeeService(repository, mapper, factory);
    }

    @Test
    public void retrieveEmployeesFromRepository(){
        service.getAllEmployees();
        Mockito.verify(repository).findAll();
    }

    @Test
    public void usesEmployeeMapper(){
        service.getAllEmployees();
        Mockito.verify(mapper, times(3)).mapEmployeeResponseFromEmployee(any());
    }

}
