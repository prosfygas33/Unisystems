package com.example.Unisystems;

import com.example.Unisystems.BusinessUnit.BusinessUnit;
import com.example.Unisystems.Company.Company;
import com.example.Unisystems.Department.Department;
import com.example.Unisystems.Employee.*;
import com.example.Unisystems.EmployeeStrategy.SearchEmployeeStrategy;
import com.example.Unisystems.EmployeeStrategy.SearchEmployeeStrategyFactory;
import com.example.Unisystems.Task.Task;
import com.example.Unisystems.Unit.Unit;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class EmployeeServiceShould {

    @Mock
    private EmployeeRepository repository;
    @Mock
    private EmployeeMapper mapper;
    @Mock
    private SearchEmployeeStrategyFactory factory;

    private EmployeeService service;
    private EmployeeResponse employeeResponseFromMapper;
    private Iterable<Employee> mockIterableEmployees;
    private List<EmployeeResponse> mockListEmployeesResponse;

    private Employee employee1, employee2, employee3;
    private Company c1;
    private BusinessUnit b1;
    private Department d1;
    private Unit u1, u2;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        c1 = new Company("UniSystems");
        b1 = new BusinessUnit("BusinessUnitA", c1);
        d1 = new Department("Human Resources", b1);
        u1 = new Unit("Fire Squad", d1);
        u1.setId(1);
        u2 = new Unit("Hiring Squad", d1);
        u2.setId(2);

        Employee employee1 = new Employee(122, "Petros", "Euthimiou", "Spetson 17", "2108834081", new Date(111, 5, 15), null, true, true, u1, null, "Senior Developer");
        employee1.setId(1);
        Employee employee2 = new Employee(123, "Mitsos", "Kitsou", "Spartis 25", "2108855284", new Date(110, 11, 5), null , true, true, u2, null, "Hr officer");
        employee2.setId(2);
        Employee employee3 = new Employee(124, "Kostas", "Fleggas", "Tsoxa 13", "2107440081", new Date(112, 7, 15), null, true, true, u2, null, " Manager");
        employee3.setId(3);

        //employeeResponseFromMapper = new EmployeeResponse(1, 122, "Euthimiou Petros", "2010-06-05 - present" , Status.ACTIVE, "ACTIVE", "Senior Developer",null,"Fire Squad");// new EmployeeResponse(1, 122, "Petros Euthimiou", "Spetson 17", "2108834081", new Date(111, 5, 15), null, true, true, c1, b1, d1, u1, null, "Senior Developer");
        employeeResponseFromMapper = new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName());
        mockIterableEmployees = new ArrayList<Employee>(){
            {
                add(employee1);
                add(employee2);
                add(employee3);
            }
        };
        mockListEmployeesResponse = new ArrayList<EmployeeResponse>(){
            {
                add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
                add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
            }
        };

        when(repository.findAll()).thenReturn(mockIterableEmployees);
        when(mapper.mapEmployeeResponseFromEmployee(any())).thenReturn(employeeResponseFromMapper);
        when(factory.makeStrategyForCriteria(any())).thenReturn(new SearchEmployeeStrategy() {
            @Override
            public List<Employee> execute(Long criteriaId, Iterable<Employee> allEmployees) {
                return null;
            }
        });
        when(mapper.mapAllEmployees(any())).thenReturn(mockListEmployeesResponse);

        service = new EmployeeService(repository, mapper, factory);

    }

    @Test
    public void retrieveEmployeesFromRepository(){
        service.getAllEmployees();
        Mockito.verify(repository).findAll();
        Mockito.clearInvocations(repository);

        service.getAllEmployeesById((long) 1);
        Mockito.verify(repository).findAll();
        Mockito.clearInvocations(repository);

        service.getAllEmployeesByCriteria("unit", (long) 1);
        Mockito.verify(repository).findAll();
    }

    @Test
    public void usesEmployeeMapper(){
        service.getAllEmployees();
        Mockito.verify(mapper, times(3)).mapEmployeeResponseFromEmployee(any());
        Mockito.clearInvocations(mapper);

        service.getAllEmployeesById((long) 1);
        Mockito.verify(mapper).mapEmployeeResponseFromEmployee(any());
        Mockito.clearInvocations(mapper);

        service.getAllEmployeesByCriteria("unit", (long) 1);
        Mockito.verify(mapper).mapAllEmployees(any());
    }

    @Test
    public void usesSearchEmployeeStrategyFactory(){
        service.getAllEmployeesByCriteria("unit", (long) 1);
        Mockito.verify(factory).makeStrategyForCriteria("unit");
    }

    @Test
    public void returnListFrom_getAllEmployees(){
        List<EmployeeResponse> output = service.getAllEmployees();
        assertEquals(3, output.size());

        List<EmployeeResponse> expected = new ArrayList<>();
        expected.add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
        expected.add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
        expected.add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
        Assert.assertThat(output.get(0), Matchers.samePropertyValuesAs(expected.get(0)));
        Assert.assertThat(output.get(1), Matchers.samePropertyValuesAs(expected.get(1)));
        Assert.assertThat(output.get(2), Matchers.samePropertyValuesAs(expected.get(2)));
    }

    @Test
    public void returnListFrom_getAllEmployeesById(){
        GenericResponse<List<EmployeeResponse>> output = service.getAllEmployeesById((long) 1);
        assertEquals(1, output.getData().size());

        List<EmployeeResponse> expected = new ArrayList<>();
        expected.add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
        Assert.assertThat(output.getData().get(0), Matchers.samePropertyValuesAs(expected.get(0)));
    }

    @Test
    public void returnListFrom_getAllEmployeesByCriteria(){
        GenericResponse<List<EmployeeResponse>> output = service.getAllEmployeesByCriteria("unit", 1L);
        assertEquals(2, output.getData().size());

        List<EmployeeResponse> expected = new ArrayList<>();
        expected.add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
        expected.add(new EmployeeResponse(1, "Euthimiou Petros","2108834081", "2010-06-05 - present", Status.ACTIVE, "ACTIVE", "Senior Developer",null,u1.getName()));
        Assert.assertThat(output.getData().get(0), Matchers.samePropertyValuesAs(expected.get(0)));
        Assert.assertThat(output.getData().get(1), Matchers.samePropertyValuesAs(expected.get(1)));
    }
}
