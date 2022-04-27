package com.corso.exercise1.controller;

import com.corso.exercise1.domain.Employee;
import com.corso.exercise1.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

//per usare when e verify di MOCKITO
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Autowired
    Employee employee;
    List<Employee> list;

    @BeforeEach
    public void setUp(){
        employee=new Employee("1","impiegato1","aaa",18);
        mockMvc= MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @AfterEach
    public void tearDown(){
        list=null;
        employee=null;
    }

    @Test
    public void GetMappingOfAllEmployees() throws Exception {
        when(employeeService.getAllEmployees()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/exercise1/getAll")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee))).andDo(MockMvcResultHandlers.print());
        verify(employeeService).getAllEmployees();
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    public void getEmployeById() throws Exception {
        when(employeeService.getEmlpoyeeByid(employee.getId())).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/exercise1/employee/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(employee)))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getDeleteEmployeById() throws Exception {
        when(employeeService.deleteEmployeeById(employee.getId())).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/exercise1/delete/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(employee)))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void PostMappingOfEmployee() throws Exception {
        Employee employee1= new Employee("2","Andrea","Rossi",30);
        when(employeeService.addEmployee(any())).thenReturn(employee1);
        when(employeeService.addEmployee(any())).thenReturn(employee1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/exercise1/insert").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee1))).andExpect(status().isCreated());
        verify(employeeService, times(1)).addEmployee(any());
    }



    //metodo statico per trasformare gli oggett in JSon
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
