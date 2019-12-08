package com.example.Unisystems;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UnisystemsApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeesFeature {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAllEmployees() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                    .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isOk())
                    .andExpect(content().json(AllEmployeesJson.json));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllEmployeesById(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")
                    .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isOk())
                    .andExpect(content().json(AllEmployeesByIdJson.json));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllEmployeesByIdNotFound(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/employees/1000")
                    .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isBadRequest())
                    .andExpect(content().json(AllEmployeesByIdJson.jsonNotFound));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllEmployeesByCriteria() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/employeesByCriteria/unit/4")
                    .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isOk())
                    .andExpect(content().json(AllEmployeesByCriteriaJson.json));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllEmployeesByCriteriaWrongInput(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/employeesByCriteria/uni/4")
                    .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isBadRequest())
                    .andExpect(content().json(AllEmployeesByCriteriaJson.jsonWrongInput));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllEmployeesByCriteriaNotFound() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/employeesByCriteria/unit/1")
                    .contentType(MediaType.APPLICATION_JSON)
            )
                    .andExpect(status().isBadRequest())
                    .andExpect(content().json(AllEmployeesByCriteriaJson.jsonNotFound));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}