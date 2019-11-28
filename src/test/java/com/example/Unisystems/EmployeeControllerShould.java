package com.example.Unisystems;

import com.example.Unisystems.Employee.EmployeeController;
import com.example.Unisystems.Employee.EmployeeResponse;
import com.example.Unisystems.Employee.EmployeeService;
import com.example.Unisystems.Employee.GetAllEmployees;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeControllerShould {
    private EmployeeController controller;

    @Mock
    private EmployeeService service;

    @Mock
    private EmployeeResponse employee1;
    @Mock
    private EmployeeResponse employee2;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        List<EmployeeResponse> mockedEmployees = new ArrayList<>();
        mockedEmployees.add(employee1);
        mockedEmployees.add(employee2);
        GenericResponse<List<EmployeeResponse>> mockedResponse = new GenericResponse(mockedEmployees);

        when(service.getAllEmployees()).thenReturn(mockedEmployees);
        when(service.getAllEmployeesById(any())).thenReturn(mockedResponse);
        when(service.getAllEmployeesByCriteria(any(), any())).thenReturn(mockedResponse);

        controller = new EmployeeController(service);
    }

    @Test
    public void returnAllEmployees(){
        ResponseEntity<GetAllEmployees> actual = controller.getAllEmployees();

        Assert.assertThat(actual.getBody().getEmployees(), CoreMatchers.hasItems(employee1, employee2));
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void returnAllEmployeesById(){
        ResponseEntity<GetAllEmployees> actual = controller.getAllEmployeesById(any());

        Assert.assertThat(actual.getBody().getEmployees(), CoreMatchers.hasItems(employee1, employee2));
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void returnAllEmployeesByCriteria(){
        ResponseEntity<GetAllEmployees> actual = controller.getAllEmployeesById(any());

        Assert.assertThat(actual.getBody().getEmployees(), CoreMatchers.hasItems(employee1, employee2));
        Assert.assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void returnsErrorWhenServiceFailsGettingAllEmployeesById() {
        Error error = mockServiceFailureNotFound();
        ResponseEntity<List<EmployeeResponse>> actual = controller.getAllEmployeesById(any());
        Assert.assertEquals(error, actual.getBody());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
    }

    @Test
    public void returnsErrorWhenServiceFailsGettingAllEmployeesByCriteria() {
        Error error = mockServiceFailureNotFound();
        ResponseEntity<List<EmployeeResponse>> actual = controller.getAllEmployeesByCriteria(any(), any());
        Assert.assertEquals(error, actual.getBody());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());

        error = mockServiceFailureWrongInput();
        actual = controller.getAllEmployeesByCriteria(any(), any());
        Assert.assertEquals(error, actual.getBody());
        Assert.assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
    }


    private Error mockServiceFailureNotFound() {
        Error error = new Error(0,"Not Found", "No employee record exist for given id " + 1L);
        when(service.getAllEmployeesById(any())).thenReturn(new GenericResponse<>(error));
        when(service.getAllEmployeesByCriteria(any(), any())).thenReturn(new GenericResponse<>(error));
        controller = new EmployeeController(service);
        return error;
    }

    private Error mockServiceFailureWrongInput() {
        Error error = new Error(0,"Wrong Input", "This " +  "unit" + " do not exist");
        when(service.getAllEmployeesByCriteria(any(), any())).thenReturn(new GenericResponse<>(error));
        controller = new EmployeeController(service);
        return error;
    }
}
